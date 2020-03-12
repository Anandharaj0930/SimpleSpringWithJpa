package test.spring.config;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class CsrfHeaderFilter implements Filter {

	protected static Logger LOGGER = Logger.getLogger(CsrfHeaderFilter.class);


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		LOGGER.debug("CSRF Filter doFilterInternal");
		filterChain.doFilter(servletRequest, servletResponse);
	}


	@Override
	public void destroy() {

	}

}