/**
 * 
 */
package com.lvmama.report.service;

import java.util.List;

import com.lvmama.report.vo.ReportDefinitionVO;

/**
 * @author fengyonggang
 *
 */
public interface ReportDefinitionService {

	ReportDefinitionVO saveReportDefinition(ReportDefinitionVO definitionVO);
	
	List<ReportDefinitionVO> findAllReportDefinitions();
	
	ReportDefinitionVO findReportDefinition(Integer defId);
}
