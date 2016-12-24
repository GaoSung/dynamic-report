/**
 * 
 */
package com.lvmama.report.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fengyonggang
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	public void index(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("/swagger-ui.html");
	}
}
