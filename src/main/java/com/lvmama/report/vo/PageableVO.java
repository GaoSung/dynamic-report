/**
 * 
 */
package com.lvmama.report.vo;

import java.io.Serializable;

/**
 * @author fengyonggang
 *
 */
public class PageableVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int pageNumber = 0;
	private int pageSize = 20;
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
