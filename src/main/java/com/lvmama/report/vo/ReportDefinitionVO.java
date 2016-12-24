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
public class ReportDefinitionVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String dataSource;
	private String name;
	private List<ReportDefinitionFieldVO> reportDefinitionFields;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ReportDefinitionFieldVO> getReportDefinitionFields() {
		return reportDefinitionFields;
	}
	public void setReportDefinitionFields(List<ReportDefinitionFieldVO> reportDefinitionFields) {
		this.reportDefinitionFields = reportDefinitionFields;
	}
}
