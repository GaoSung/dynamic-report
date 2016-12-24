/**
 * 
 */
package com.lvmama.report.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author fengyonggang
 *
 */
public class SearchVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<SearchParamVO> search;

	public List<SearchParamVO> getSearch() {
		return search;
	}
	public void setSearch(List<SearchParamVO> search) {
		this.search = search;
	}

}
