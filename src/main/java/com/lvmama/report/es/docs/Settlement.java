/**
 * 
 */
package com.lvmama.report.es.docs;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author fengyonggang
 *
 */
@Document(indexName = "test", type = "settlement")
public class Settlement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String productName;
	private Long price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
}
