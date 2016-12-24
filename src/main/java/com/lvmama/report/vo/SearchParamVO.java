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
public class SearchParamVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String field;
	private List<String> value;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}
}
