/**
 * 
 */
package com.lvmama.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvmama.report.domain.ReportFieldEntity;

/**
 * @author fengyonggang
 *
 */
@Repository
public interface ReportFieldRepository extends JpaRepository<ReportFieldEntity, Integer>{

}
