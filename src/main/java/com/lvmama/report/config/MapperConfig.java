/**
 * 
 */
package com.lvmama.report.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lvmama.report.mapper.DozerCustomFieldMapper;
import com.lvmama.report.mapper.DozerMapper;
import com.lvmama.report.mapper.DozerMappingImpl;

/**
 * @author fengyonggang
 *
 */
@Configuration
public class MapperConfig {

	@Bean
	public DozerMapper dozerMapper() {
		DozerMappingImpl mapper = new DozerMappingImpl();
		mapper.setCustomFieldMapper(new DozerCustomFieldMapper());
		return mapper;
	}
	
}
