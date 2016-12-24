/**
 * 
 */
package com.lvmama.report.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.lvmama.report.domain.ReportDefinitionEntity;
import com.lvmama.report.domain.ReportDefinitionFieldEntity;
import com.lvmama.report.mapper.DozerMapper;
import com.lvmama.report.repository.ReportDefinitionFieldRepository;
import com.lvmama.report.repository.ReportDefinitionRepository;
import com.lvmama.report.vo.ReportDefinitionVO;

/**
 * @author fengyonggang
 *
 */
@Service
public class ReportDefinitionServiceImpl implements ReportDefinitionService {

	@Autowired
	private ReportDefinitionRepository reportDefinitionReporitory;
	@Autowired
	private ReportDefinitionFieldRepository reportDefinitionFieldRepository;
	
	@Autowired
	private DozerMapper mapper;
	
	@Override
	@Transactional
	public ReportDefinitionVO saveReportDefinition(ReportDefinitionVO definitionVO) {
		ReportDefinitionEntity definition = null;
		List<ReportDefinitionFieldEntity> fields = new ArrayList<>();
		if(definitionVO.getId() == null || definitionVO.getId() == 0) {
			definition = mapper.map(definitionVO, ReportDefinitionEntity.class);
			fields = definition.getReportDefinitionFields();
		} else {
			definition = reportDefinitionReporitory.findOne(definitionVO.getId());
			definition.setDataSource(definitionVO.getDataSource());
			definition.setName(definitionVO.getName());
			if(!CollectionUtils.isEmpty(definitionVO.getReportDefinitionFields())) {
				fields = mapper.mapToList(definitionVO.getReportDefinitionFields(), ReportDefinitionFieldEntity.class);
			}
			if(definition.getReportDefinitionFields() != null) {
				for(ReportDefinitionFieldEntity field : definition.getReportDefinitionFields()) {
					if(!fields.contains(field)) {
						reportDefinitionFieldRepository.delete(field.getId());
					}
				}
			}
		}
		
		ReportDefinitionEntity newDefinition = reportDefinitionReporitory.save(definition);
		if(fields != null) {
			for(ReportDefinitionFieldEntity field : fields) {
				field.setReportDefinition(newDefinition);
			}
			reportDefinitionFieldRepository.save(fields);
		}
		
		newDefinition.setReportDefinitionFields(fields);
		return mapper.map(newDefinition, ReportDefinitionVO.class);
	}

	@Override
	public List<ReportDefinitionVO> findAllReportDefinitions() {
		List<ReportDefinitionEntity> defs = reportDefinitionReporitory.findAll();
		return mapper.mapToList(defs, ReportDefinitionVO.class);
	}
	
	@Override
	public ReportDefinitionVO findReportDefinition(Integer defId) {
		ReportDefinitionEntity newDefinition = reportDefinitionReporitory.findOneWithFields(defId);
		if(newDefinition == null) 
			return null;
		return mapper.map(newDefinition, ReportDefinitionVO.class);
	}
}
