/**
 * 
 */
package com.lvmama.report.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.lvmama.report.es.docs.Settlement;

/**
 * @author fengyonggang
 *
 */
@Repository
public interface SettlementRepository extends ElasticsearchRepository<Settlement, String> {

}
