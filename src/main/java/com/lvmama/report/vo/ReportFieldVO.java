/**
 * 
 */
package com.lvmama.report.vo;

import java.io.Serializable;

/**
 * @author fengyonggang
 *
 */
public class ReportFieldVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer reportDefinitionFieldId;
	private String showName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReportDefinitionFieldId() {
		return reportDefinitionFieldId;
	}
	public void setReportDefinitionFieldId(Integer reportDefinitionFieldId) {
		this.reportDefinitionFieldId = reportDefinitionFieldId;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	
}
