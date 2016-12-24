package com.lvmama.report.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@Table(name="report")
@NamedQuery(name="ReportEntity.findAll", query="SELECT r FROM ReportEntity r")
public class ReportEntity extends AbstractAuditingEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String description;

	@Column(name="report_definition_id")
	private Integer reportDefinitionId;

	@Column(name="report_name")
	private String reportName;

	@JsonIgnore
	@OneToMany(mappedBy="report")
	private List<ReportFieldEntity> reportFields;

	public ReportEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReportDefinitionId() {
		return this.reportDefinitionId;
	}

	public void setReportDefinitionId(Integer reportDefinitionId) {
		this.reportDefinitionId = reportDefinitionId;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public List<ReportFieldEntity> getReportFields() {
		return this.reportFields;
	}

	public void setReportFields(List<ReportFieldEntity> reportFields) {
		this.reportFields = reportFields;
	}

	public ReportFieldEntity addReportField(ReportFieldEntity reportField) {
		getReportFields().add(reportField);
		reportField.setReport(this);

		return reportField;
	}

	public ReportFieldEntity removeReportField(ReportFieldEntity reportField) {
		getReportFields().remove(reportField);
		reportField.setReport(null);

		return reportField;
	}

}