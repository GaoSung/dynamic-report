/**
 * 
 */
package com.lvmama.report.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lvmama.report.common.ApiUriTemplates;
import com.lvmama.report.service.ReportService;
import com.lvmama.report.vo.ReportVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author fengyonggang
 *
 */
@RestController
@Api(value = ApiUriTemplates.APP_ROOT_PATH)
@RequestMapping(ApiUriTemplates.V1 + "/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	@GetMapping
	@ApiOperation("查询所有用户报表")
	public ResponseEntity<Page<ReportVO>> findAll(
			@RequestParam(name = "page", required = false, defaultValue = "0") int pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "20") int pageSize) {
		
		Pageable pageable = new PageRequest(pageNo, pageSize);
		Page<ReportVO> page = reportService.findAllReports(pageable);
		return ResponseEntity.ok(page);
	}
	
	@PostMapping
	@ApiOperation("添加用户报表")
	public ResponseEntity<ReportVO> addReport(@RequestBody ReportVO reportVO) {
		ReportVO report = reportService.saveReport(reportVO);
		return ResponseEntity.ok(report);
	}
	
	@GetMapping("/{reportId}")
	@ApiOperation("查询用户报表")
	public ResponseEntity<ReportVO> findReport(@PathVariable("reportId") Integer reportId) {
		ReportVO report = reportService.findReport(reportId);
		return ResponseEntity.ok(report);
	}
}
