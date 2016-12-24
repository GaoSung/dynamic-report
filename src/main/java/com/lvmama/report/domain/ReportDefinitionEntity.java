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
 * The persistent class for the report_definition database table.
 * 
 */
@Entity
@Table(name="report_definition")
@NamedQuery(name="ReportDefinitionEntity.findAll", query="SELECT r FROM ReportDefinitionEntity r")
public class ReportDefinitionEntity extends AbstractAuditingEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="data_source")
	private String dataSource;

	private String name;

	@JsonIgnore
	@OneToMany(mappedBy="reportDefinition")
	private List<ReportDefinitionFieldEntity> reportDefinitionFields;

	public ReportDefinitionEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ReportDefinitionFieldEntity> getReportDefinitionFields() {
		return this.reportDefinitionFields;
	}

	public void setReportDefinitionFields(List<ReportDefinitionFieldEntity> reportDefinitionFields) {
		this.reportDefinitionFields = reportDefinitionFields;
	}

	public ReportDefinitionFieldEntity addReportDefinitionField(ReportDefinitionFieldEntity reportDefinitionField) {
		getReportDefinitionFields().add(reportDefinitionField);
		reportDefinitionField.setReportDefinition(this);

		return reportDefinitionField;
	}

	public ReportDefinitionFieldEntity removeReportDefinitionField(ReportDefinitionFieldEntity reportDefinitionField) {
		getReportDefinitionFields().remove(reportDefinitionField);
		reportDefinitionField.setReportDefinition(null);

		return reportDefinitionField;
	}

}