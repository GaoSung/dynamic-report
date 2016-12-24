/**
 * 
 */
package com.lvmama.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lvmama.report.domain.ReportDefinitionEntity;

/**
 * @author fengyonggang
 *
 */
@Repository
public interface ReportDefinitionRepository extends JpaRepository<ReportDefinitionEntity, Integer>{

	@Query("SELECT r FROM ReportDefinitionEntity r LEFT JOIN FETCH r.reportDefinitionFields WHERE r.id = ?1")
	ReportDefinitionEntity findOneWithFields(Integer id);
}
