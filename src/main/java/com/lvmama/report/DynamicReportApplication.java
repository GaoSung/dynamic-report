/**
 * 
 */
package com.lvmama.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.lvmama.report.config.ReportProperties;

/**
 * @author fengyonggang
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(ReportProperties.class)
public class DynamicReportApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DynamicReportApplication.class, args);
	}

}
