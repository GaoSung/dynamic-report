/**
 * 
 */
package com.lvmama.report.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvmama.report.common.ApiUriTemplates;
import com.lvmama.report.service.EsCatService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author fengyonggang
 *
 */
@RestController
@Api(value = ApiUriTemplates.APP_ROOT_PATH)
@RequestMapping(ApiUriTemplates.V1 + "/cat")
public class ESCatController {

	@Autowired
	private EsCatService catService;

	@ApiOperation("查询ES中的索引名称")
	@GetMapping("/indices")
	public ResponseEntity<List<String>> listIndices() {
		List<String> indices = catService.listIndices();
		return ResponseEntity.ok(indices);
	}
	
	@ApiOperation("查询ES中的所有索引及Type名称")
	@GetMapping("/types")
	public ResponseEntity<List<String>> listIndiceTypes() {
		List<String> indices = catService.listIndicesAndTypes();
		return ResponseEntity.ok(indices);
	}
	
	@ApiOperation("查询ES中的某个索引的Type名称")
	@GetMapping("/indices/{index}")
	public ResponseEntity<List<String>> findIndexTypes(@PathVariable("index") String index) {
		List<String> indices = catService.findIndexTypes(index);
		return ResponseEntity.ok(indices);
	}
	
	@ApiOperation("查询ES中的Type字段信息")
	@GetMapping("/indices/{index}/{type}")
	public ResponseEntity<List<String>> findTypeFields(@PathVariable("index") String index, @PathVariable("type") String type) {
		List<String> indices = catService.findTypeFields(index, type);
		return ResponseEntity.ok(indices);
	}
}
