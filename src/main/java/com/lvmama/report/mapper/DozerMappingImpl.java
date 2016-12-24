/**
 * 
 */
package com.lvmama.report.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;

/**
 * @author fengyonggang
 *
 */
public class DozerMappingImpl extends DozerBeanMapper implements DozerMapper {

	@Override
	public <S, D> List<D> mapToList(List<S> source, Class<D> destinationClass) {
		final List<D> result = new ArrayList<D>();
		for (S element : source) {
			result.add(this.map(element, destinationClass));
		}
		return result;
	}

	@Override
	public <S, D> List<D> mapToList(Set<S> source, Class<D> destinationClass) {
		final List<D> result = new ArrayList<D>();
		for (S element : source) {
			result.add(this.map(element, destinationClass));
		}
		return result;
	}

	public <S, D> Page<D> mapToPage(Page<S> page, Pageable pageable, Class<D> destinationClass) {
		List<D> result = null;
		if (!CollectionUtils.isEmpty(page.getContent())) {
			result = this.mapToList(page.getContent(), destinationClass);
		} else {
			result = new ArrayList<D>();
		}
		return new PageImpl<D>(result, pageable, page.getTotalElements());
	}
}
