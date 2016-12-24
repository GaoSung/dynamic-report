/**
 * 
 */
package com.lvmama.report.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

/**
 * @author fengyonggang
 *
 */
public class JsonUtils {

	public static <T> T jsonToObject(String str, Class<T> clazz) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return mapper.readValue(str, clazz);
		} catch (Exception e) {
			return null;
		} 
    }
	
	public static String objectToJsonString(Object obj) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {

		}
    	return "{}";
    }
	
	public static <T> List<T> jsonToList(String str, Class<T> elementClass) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, elementClass);
    		return mapper.readValue(str, type);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
    }
	
	public static <T> Map<String, T> jsonToMap(String str, Class<T> valueClass) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		MapType type = mapper.getTypeFactory().constructMapType(Map.class, String.class, valueClass);
			return mapper.readValue(str, type);
		} catch (Exception e) {
			return new HashMap<String, T>();
		} 
    }
	
	public static JsonNode jsonToNode(String str) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readTree(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
