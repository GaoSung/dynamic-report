/**
 * 
 */
package com.lvmama.report.mapper;

import java.util.List;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author fengyonggang
 *
 */
public interface DozerMapper extends Mapper{

	/**
	 * Maps source list destination list
	 * @param source
	 * @param destinationClass
	 * @return
	 */
	<S, D> List<D> mapToList(final List<S> source, final Class<D> destinationClass);
	
	/**
	 * Maps source set destination list
	 * @param source
	 * @param destinationClass
	 * @return
	 */
	<S, D> List<D> mapToList(final Set<S> source, final Class<D> destinationClass);
	
	/**
	 * Maps spring domain page
	 * @param page
	 * @param pageable
	 * @param destinationClass
	 * @return
	 */
	<S, D> Page<D> mapToPage(Page<S> page, Pageable pageable, Class<D> destinationClass);
}
