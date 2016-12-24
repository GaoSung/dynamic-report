/**
 * 
 */
package com.lvmama.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lvmama.report.domain.ReportEntity;

/**
 * @author fengyonggang
 *
 */
@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer>{

	@Query("SELECT r FROM ReportEntity r LEFT JOIN FETCH r.reportFields WHERE r.id = ?1")
	ReportEntity findOneWithFields(Integer reportId);

}
