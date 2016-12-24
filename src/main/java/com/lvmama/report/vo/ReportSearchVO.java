/**
 * 
 */
package com.lvmama.report.vo;

/**
 * @author fengyonggang
 *
 */
public class ReportSearchVO extends SearchVO {

	private static final long serialVersionUID = 1L;
	private Integer reportId;
	private PageableVO pageable = new PageableVO();

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public PageableVO getPageable() {
		return pageable;
	}

	public void setPageable(PageableVO pageable) {
		this.pageable = pageable;
	}

}
