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
public class ReportVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String description;
	private Integer reportDefinitionId;
	private String reportName;
	private List<ReportFieldVO> reportFields;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getReportDefinitionId() {
		return reportDefinitionId;
	}
	public void setReportDefinitionId(Integer reportDefinitionId) {
		this.reportDefinitionId = reportDefinitionId;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public List<ReportFieldVO> getReportFields() {
		return reportFields;
	}
	public void setReportFields(List<ReportFieldVO> reportFields) {
		this.reportFields = reportFields;
	}
	
}
