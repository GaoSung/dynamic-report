/**
 * 
 */
package com.lvmama.report.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import com.lvmama.report.common.FieldType;
import com.lvmama.report.domain.ReportDefinitionEntity;
import com.lvmama.report.domain.ReportDefinitionFieldEntity;
import com.lvmama.report.domain.ReportEntity;
import com.lvmama.report.domain.ReportFieldEntity;
import com.lvmama.report.repository.ReportDefinitionRepository;
import com.lvmama.report.repository.ReportRepository;
import com.lvmama.report.vo.ReportSearchVO;
import com.lvmama.report.vo.SearchParamVO;
import com.lvmama.report.vo.SearchResultVO;

/**
 * @author fengyonggang
 *
 */
@Service
public class ESSearchService implements SearchService {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private ReportDefinitionRepository reportDefinitionRepository;
	
	@Override
	public Page<SearchResultVO> search(ReportSearchVO searchVO) {
		Integer reportId = searchVO.getReportId();
		if(reportId == null || reportId == 0) 
			throw new IllegalArgumentException("ReportId should not be null");
		ReportEntity report = reportRepository.findOneWithFields(reportId);
		if(report == null || CollectionUtils.isEmpty(report.getReportFields())) 
			throw new RuntimeException("Can not found report or field based on report id: " + reportId);
		
		Pageable pageable = new PageRequest(searchVO.getPageable().getPageNumber(), searchVO.getPageable().getPageSize());
		CriteriaQuery cq = buildCriteriaQuery(searchVO.getSearch(), pageable, report);
		
		return elasticsearchTemplate.queryForPage(cq, SearchResultVO.class);
	}
	
	private CriteriaQuery buildCriteriaQuery(List<SearchParamVO> params, Pageable pageable, ReportEntity report) {
		ReportDefinitionEntity def = reportDefinitionRepository.findOneWithFields(report.getReportDefinitionId());
		if(def == null || CollectionUtils.isEmpty(def.getReportDefinitionFields())) {
			throw new RuntimeException("Can not found report definition or field definition based on report definition id: " + report.getReportDefinitionId());
		}
		
		Criteria criteria = buildCriteria(params, def);
		CriteriaQuery cq = new CriteriaQuery(criteria, pageable);
		
		String [] dsArr = def.getDataSource().split("/");
		cq.addIndices(dsArr[0]);
		if(dsArr.length > 1) {
			cq.addTypes(dsArr[1]);
		} else {
			throw new RuntimeException("Invalid datasource: " + def.getDataSource());
		}
		
		for(ReportFieldEntity reportField : report.getReportFields()) {
			if(reportField.getReportDefinitionFieldId() == null || reportField.getReportDefinitionFieldId() == 0) {
				continue;
			}
			for(ReportDefinitionFieldEntity fieldDef : def.getReportDefinitionFields()) {
				if(reportField.getReportDefinitionFieldId().intValue() == fieldDef.getId().intValue()) {
					cq.addFields(fieldDef.getFieldName());
					break;
				}
			}
		}
		
		return cq;
	}
	
	private Criteria buildCriteria(List<SearchParamVO> params, ReportDefinitionEntity def) {
		if(CollectionUtils.isEmpty(params)) {
			return null;
		}
		Criteria criteria = null;
		for(SearchParamVO param : params) {
			if(param.getValue() == null || param.getValue().isEmpty()) {
				continue;
			}
			ReportDefinitionFieldEntity fieldDef = findFieldDefByName(param.getField(), def.getReportDefinitionFields());
			if(fieldDef == null) {
				continue;
			}
			
			if(criteria == null) {
				criteria = Criteria.where(param.getField());
			} else {
				criteria = criteria.and(param.getField());
			}

			if(FieldType.RANGE.equals(fieldDef.getShowType()) || 
					FieldType.RANGE_DATETIME.equals(fieldDef.getShowType())) {
				if(param.getValue().size() == 1) {
					criteria.greaterThanEqual(param.getValue().get(0));
				} else {
					String lowerBound = param.getValue().get(0);
					String upperBound = param.getValue().get(1);
					if(lowerBound == null && upperBound == null) {
						continue;
					} else if(lowerBound == null) {
						criteria.lessThanEqual(upperBound);
					} else if(upperBound == null) {
						criteria.greaterThanEqual(lowerBound);
					} else {
						criteria.between(lowerBound, upperBound);
					}
				}
			} else if(FieldType.CHECKBOX.equals(fieldDef.getShowType())){
				if(param.getValue().size() == 1) {
					criteria.is(param.getValue().get(0));
				} else {
					criteria.in(param.getValue());
				}
			} else {
				criteria.is(param.getValue().get(0));
			}
		}
		return criteria;
	}
	
	private ReportDefinitionFieldEntity findFieldDefByName(String fieldName, List<ReportDefinitionFieldEntity> fieldDefs) {
		for(ReportDefinitionFieldEntity fieldDef : fieldDefs) {
			if(fieldDef.getFieldName().equals(fieldName)) {
				return fieldDef;
			}
		}
		return null;
	}
}
