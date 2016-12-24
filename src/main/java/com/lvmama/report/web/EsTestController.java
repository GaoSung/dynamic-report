/**
 * 
 */
package com.lvmama.report.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvmama.report.es.docs.Settlement;
import com.lvmama.report.service.SettlementService;

/**
 * @author fengyonggang
 *
 */
@RestController
@RequestMapping("/test")
public class EsTestController {

	@Autowired
	private SettlementService settlementService;
	
	@GetMapping("/settlement")
	public Page<Settlement> findAllSettlements() {
		return settlementService.findAllSettlements();
	}
	
	@GetMapping("/settlement/post")
	public Settlement addSettlement() {
		Settlement se = new Settlement();
		se.setProductName("产品1");
		se.setPrice(100L);
		return settlementService.addSettlement(se);
	}
	
	@GetMapping("/settlement/{id}")
	public Settlement findSettlement(@PathVariable("id") String id) {
		return settlementService.findById(id);
	}
}
