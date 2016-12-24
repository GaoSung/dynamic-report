/**
 * 
 */
package com.lvmama.report.service;

import org.springframework.data.domain.Page;

import com.lvmama.report.vo.ReportSearchVO;
import com.lvmama.report.vo.SearchResultVO;

/**
 * @author fengyonggang
 *
 */
public interface SearchService {

	Page<SearchResultVO> search(ReportSearchVO searchVO);
}
