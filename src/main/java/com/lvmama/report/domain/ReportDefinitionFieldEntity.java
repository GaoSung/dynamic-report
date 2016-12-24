package com.lvmama.report.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lvmama.report.common.FieldType;


/**
 * The persistent class for the report_definition_field database table.
 * 
 */
@Entity
@Table(name="report_definition_field")
@NamedQuery(name="ReportDefinitionFieldEntity.findAll", query="SELECT r FROM ReportDefinitionFieldEntity r")
public class ReportDefinitionFieldEntity extends AbstractAuditingEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="field_name")
	private String fieldName;

	@Column(name="show_name")
	private String showName;

	@Column(name="show_option")
	private String showOption;

	@Enumerated(EnumType.STRING)
	@Column(name="show_type")
	private FieldType showType;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="report_definition_id")
	private ReportDefinitionEntity reportDefinition;

	public ReportDefinitionFieldEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getShowName() {
		return this.showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowOption() {
		return this.showOption;
	}

	public void setShowOption(String showOption) {
		this.showOption = showOption;
	}

	public FieldType getShowType() {
		return this.showType;
	}

	public void setShowType(FieldType showType) {
		this.showType = showType;
	}

	public ReportDefinitionEntity getReportDefinition() {
		return this.reportDefinition;
	}

	public void setReportDefinition(ReportDefinitionEntity reportDefinition) {
		this.reportDefinition = reportDefinition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportDefinitionFieldEntity other = (ReportDefinitionFieldEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}