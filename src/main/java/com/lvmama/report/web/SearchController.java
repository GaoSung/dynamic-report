/**
 * 
 */
package com.lvmama.report.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvmama.report.common.ApiUriTemplates;
import com.lvmama.report.service.SearchService;
import com.lvmama.report.vo.ReportSearchVO;
import com.lvmama.report.vo.SearchResultVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author fengyonggang
 *
 */
@RestController
@Api(value = ApiUriTemplates.APP_ROOT_PATH)
@RequestMapping(ApiUriTemplates.V1 + "/search")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@ApiOperation("查询报表数据")
	@PostMapping
	public ResponseEntity<Page<SearchResultVO>> search(@RequestBody ReportSearchVO searchVO) {
		Page<SearchResultVO> page = searchService.search(searchVO);
		return ResponseEntity.ok(page);
	}
}
