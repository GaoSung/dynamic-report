/**
 * 
 */
package com.lvmama.report.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author fengyonggang
 *
 */
@ConfigurationProperties(prefix = "report")
public class ReportProperties {

	private final ESProperties es = new ESProperties();

	public ESProperties getEs() {
		return this.es;
	}

	public static class ESProperties {
		private String httpNodes;

		public String getHttpNodes() {
			return httpNodes;
		}

		public void setHttpNodes(String httpNodes) {
			this.httpNodes = httpNodes;
		}
	}
}
