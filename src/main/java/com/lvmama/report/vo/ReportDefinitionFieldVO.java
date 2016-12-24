/**
 * 
 */
package com.lvmama.report.vo;

import java.io.Serializable;

import com.lvmama.report.common.FieldType;

/**
 * @author fengyonggang
 *
 */
public class ReportDefinitionFieldVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fieldName;
	private String showName;
	private String showOption;
	private FieldType showType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getShowOption() {
		return showOption;
	}
	public void setShowOption(String showOption) {
		this.showOption = showOption;
	}
	public FieldType getShowType() {
		return showType;
	}
	public void setShowType(FieldType showType) {
		this.showType = showType;
	}
	
}
