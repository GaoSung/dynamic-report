/**
 * 
 */
package com.lvmama.report.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author fengyonggang
 *
 */
@Configuration
public class DataSourceConfig {

	@Configuration
	@EnableJpaRepositories(basePackages = "com.lvmama.report.repository")
	static class JpaConfig {
		
		@Bean
		public AuditorAware<String> myAuditorAware() {
			return new AuditorAware<String>() {
				@Override
				public String getCurrentAuditor() {
					return "admin";
				}
			};
		}
		
		@Configuration
		@EnableJpaAuditing(auditorAwareRef = "myAuditorAware")
		public static class JpaAuditConfig {
		}
	}
	
	@EnableElasticsearchRepositories(basePackages = "com.lvmama.report.es.repository")
	static class ElasticSearchConfig {
		
	}
}
