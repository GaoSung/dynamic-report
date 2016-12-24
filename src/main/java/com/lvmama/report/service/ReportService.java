/**
 * 
 */
package com.lvmama.report.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lvmama.report.vo.ReportVO;

/**
 * @author fengyonggang
 *
 */
public interface ReportService {

	ReportVO saveReport(ReportVO reportVO);

	Page<ReportVO> findAllReports(Pageable pageable);

	ReportVO findReport(Integer reportId);
}
