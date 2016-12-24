/**
 * 
 */
package com.lvmama.report.service;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.lvmama.report.es.docs.Settlement;
import com.lvmama.report.es.repository.SettlementRepository;

/**
 * @author fengyonggang
 *
 */
@Service
public class SettlementServiceImpl implements SettlementService {

	@Autowired
	private SettlementRepository settlementRepository;
	
	@Override
	public Page<Settlement> findAllSettlements() {
//		return settlementRepository.findAll()
		SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery()).build();
		return settlementRepository.search(query);
	}
	
	@Override
	public Settlement findById(String id) {
		return settlementRepository.findOne(id);
	}
	
	@Override
	public Settlement addSettlement(Settlement se) {
		return settlementRepository.save(se);
	}
	
}
