/**
 * 
 */
package com.lvmama.report.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.lvmama.report.domain.ReportEntity;
import com.lvmama.report.domain.ReportFieldEntity;
import com.lvmama.report.mapper.DozerMapper;
import com.lvmama.report.repository.ReportFieldRepository;
import com.lvmama.report.repository.ReportRepository;
import com.lvmama.report.vo.ReportVO;

/**
 * @author fengyonggang
 *
 */
@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private ReportFieldRepository reportFieldRepository;
	@Autowired
	private DozerMapper mapper;
	
	@Override
	@Transactional
	public ReportVO saveReport(ReportVO reportVO) {
		ReportEntity report = null;
		List<ReportFieldEntity> fields = new ArrayList<>();
		if(reportVO.getId() == null || reportVO.getId() == 0) {
			report = mapper.map(reportVO, ReportEntity.class);
			fields = report.getReportFields();
		} else {
			report = reportRepository.findOne(reportVO.getId());
			report.setDescription(reportVO.getDescription());
			report.setReportDefinitionId(reportVO.getReportDefinitionId());
			report.setReportName(reportVO.getReportName());
			if(!CollectionUtils.isEmpty(reportVO.getReportFields())) {
				fields = mapper.mapToList(reportVO.getReportFields(), ReportFieldEntity.class);
			}
			if(report.getReportFields() != null) {
				for(ReportFieldEntity field : report.getReportFields()) {
					if(!fields.contains(field)) {
						reportFieldRepository.delete(field.getId());
					}
				}
			}
		}
		
		ReportEntity newReport = reportRepository.save(report);
		if(fields != null) {
			for(ReportFieldEntity field : fields) {
				field.setReport(newReport);
			}
			reportFieldRepository.save(fields);
		}
		
		newReport.setReportFields(fields);
		return mapper.map(newReport, ReportVO.class);
	}

	@Override
	public Page<ReportVO> findAllReports(Pageable pageable) {
		Page<ReportEntity> page = reportRepository.findAll(pageable);
		return mapper.mapToPage(page, pageable, ReportVO.class);
	}

	@Override
	public ReportVO findReport(Integer reportId) {
		ReportEntity report = reportRepository.findOneWithFields(reportId);
		if(report == null) 
			return null;
		return mapper.map(report, ReportVO.class);
	}
	
}
