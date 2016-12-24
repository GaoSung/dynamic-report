/**
 * 
 */
package com.lvmama.report.service;

import org.springframework.data.domain.Page;

import com.lvmama.report.es.docs.Settlement;

/**
 * @author fengyonggang
 *
 */
public interface SettlementService {

	Page<Settlement> findAllSettlements();
	
	Settlement findById(String id);
	
	Settlement addSettlement(Settlement se);
}
