package com.lvmama.report.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the report_field database table.
 * 
 */
@Entity
@Table(name="report_field")
@NamedQuery(name="ReportFieldEntity.findAll", query="SELECT r FROM ReportFieldEntity r")
public class ReportFieldEntity extends AbstractAuditingEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="report_definition_field_id")
	private Integer reportDefinitionFieldId;

	@Column(name="show_name")
	private String showName;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="report_id")
	private ReportEntity report;

	public ReportFieldEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReportDefinitionFieldId() {
		return this.reportDefinitionFieldId;
	}

	public void setReportDefinitionFieldId(Integer reportDefinitionFieldId) {
		this.reportDefinitionFieldId = reportDefinitionFieldId;
	}

	public String getShowName() {
		return this.showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public ReportEntity getReport() {
		return this.report;
	}

	public void setReport(ReportEntity report) {
		this.report = report;
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
		ReportFieldEntity other = (ReportFieldEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}