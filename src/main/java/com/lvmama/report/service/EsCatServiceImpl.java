/**
 * 
 */
package com.lvmama.report.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lvmama.report.config.ReportProperties;

/**
 * @author fengyonggang
 *
 */
@Service
public class EsCatServiceImpl implements EsCatService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EsCatServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ReportProperties reportProp;
	
	private String buildSearchUrl(String url) {
		String esServers = reportProp.getEs().getHttpNodes();
		String firstServer = esServers.split(",")[0];
		return "http://" + firstServer + "/" + url;
	}
	
	@Override
	public List<String> listIndices() {
		String url = buildSearchUrl("_cat/indices");
		LOGGER.debug("url to load indices: {}", url);

		String resp = restTemplate.getForObject(url, String.class);
		if(StringUtils.isEmpty(resp))
			return null;

		List<String> indices = new ArrayList<>();
		String lines[] = resp.split("\\r?\\n");
		for(String line : lines) {
			String [] lineArray = line.split("\\ +");
			if(lineArray.length > 2) {
				String indexName = lineArray[2];
				if(!indexName.startsWith(".")) {
					indices.add(indexName);
				}
			}
		}
		return indices;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<String> listIndicesAndTypes() {
		String url = buildSearchUrl("_mapping");
		LOGGER.debug("url to load mapping: {}", url);
		Map<String, ?> map = restTemplate.getForObject(url, Map.class);

		List<String> result = null;
		if(map != null && !map.isEmpty()) {
			String indexName = null;
			result = new ArrayList<>();
			for(Entry<String, ?> entry : map.entrySet()) {
				indexName = entry.getKey();
				if(indexName.startsWith(".")) { // index for internal use
					continue;
				}
				if(entry.getValue() instanceof Map) {
					Object types = ((Map<String, ?>)entry.getValue()).get("mappings");
					if(types instanceof Map) {
						for(String type : ((Map<String, ?>)types).keySet()) {
							result.add(indexName + "/" + type);
						}
					}
				}
			}
		}
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<String> findIndexTypes(String index) {
		String url = buildSearchUrl(index + "/_mapping");
		LOGGER.debug("url to load mapping: {}", url);
		Map<String, ?> map = restTemplate.getForObject(url, Map.class);
		List<String> result = null;
		if(map != null && !map.isEmpty()) {
			result = new ArrayList<>();
			for(Entry<String, ?> entry : map.entrySet()) {
				if(entry.getValue() instanceof Map) {
					Object types = ((Map<String, ?>)entry.getValue()).get("mappings");
					if(types instanceof Map) {
						result.addAll(((Map<String, ?>)types).keySet());
					}
				}
			}
		}
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<String> findTypeFields(String index, String type) {
		String url = buildSearchUrl(index + "/" + type + "/_mapping");
		LOGGER.debug("url to load mapping: {}", url);
		Map<String, ?> map = restTemplate.getForObject(url, Map.class);
		List<String> result = null;
		if(map != null && !map.isEmpty()) {
			result = new ArrayList<>();
			for(Entry<String, ?> entry : map.entrySet()) {
				if(entry.getValue() instanceof Map) {
					Object types = ((Map<String, ?>)entry.getValue()).get("mappings");
					if(types instanceof Map) {
						for(Entry<String, ?> typeEntry : ((Map<String, ?>)types).entrySet()) {
							if(typeEntry.getValue() instanceof Map) {
								Object properties = ((Map<String, ?>)typeEntry.getValue()).get("properties");
								if(properties instanceof Map) {
									result.addAll(((Map<String, ?>)properties).keySet());
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
}
