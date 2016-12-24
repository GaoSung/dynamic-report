/**
 * 
 */
package com.lvmama.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvmama.report.domain.ReportDefinitionFieldEntity;

/**
 * @author fengyonggang
 *
 */
@Repository
public interface ReportDefinitionFieldRepository extends JpaRepository<ReportDefinitionFieldEntity, Integer>{

}
