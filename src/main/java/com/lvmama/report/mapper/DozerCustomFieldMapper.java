/**
 * 
 */
package com.lvmama.report.mapper;

import org.dozer.CustomFieldMapper;
import org.dozer.classmap.ClassMap;
import org.dozer.fieldmap.FieldMap;
import org.hibernate.Hibernate;

/**
 * @author fengyonggang
 *
 */
public class DozerCustomFieldMapper implements CustomFieldMapper {

	@Override
	public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap,
			FieldMap fieldMapping) {

		// Overridden method will avoid copying object to non initialized persistent objects. 
		// This is to avoid copying the objects with fetch = FetchType.LAZY
		
		return !Hibernate.isInitialized(sourceFieldValue);
	}
}
