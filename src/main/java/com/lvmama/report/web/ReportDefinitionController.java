/**
 * 
 */
package com.lvmama.report.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvmama.report.common.ApiUriTemplates;
import com.lvmama.report.service.ReportDefinitionService;
import com.lvmama.report.vo.ReportDefinitionVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author fengyonggang
 *
 */
@RestController
@Api(value = ApiUriTemplates.APP_ROOT_PATH)
@RequestMapping(ApiUriTemplates.V1 + "/definition")
public class ReportDefinitionController {

	@Autowired
	private ReportDefinitionService reportDefinitionService;
	
	@GetMapping
	@ApiOperation("查询所有报表定义")
	public ResponseEntity<List<ReportDefinitionVO>> findAll() {
		List<ReportDefinitionVO> defs = reportDefinitionService.findAllReportDefinitions();
		return ResponseEntity.ok(defs);
	}
	
	@PostMapping
	@ApiOperation("添加报表定义")
	public ResponseEntity<ReportDefinitionVO> addReportDef(@RequestBody ReportDefinitionVO definitionVO) {
		ReportDefinitionVO def = reportDefinitionService.saveReportDefinition(definitionVO);
		return ResponseEntity.ok(def);
	}
	
	@GetMapping("/{defId}")
	@ApiOperation("查询报表定义")
	public ResponseEntity<ReportDefinitionVO> findDef(@PathVariable("defId") Integer defId) {
		ReportDefinitionVO def = reportDefinitionService.findReportDefinition(defId);
		return ResponseEntity.ok(def);
	}
}
