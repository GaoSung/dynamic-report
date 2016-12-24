/**
 * 
 */
package com.lvmama.report.service;

import java.util.List;

/**
 * @author fengyonggang
 *
 */
public interface EsCatService {

	List<String> listIndices();
	
	List<String> listIndicesAndTypes();

	List<String> findIndexTypes(String index);
	
	List<String> findTypeFields(String index, String type);
}
