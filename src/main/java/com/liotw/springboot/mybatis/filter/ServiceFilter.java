package com.liotw.springboot.mybatis.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServiceFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		// dd.addHeader(arg0, arg1);

		// 解决页面跨域访问问题
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Methods", "GET,DELETE,POST,PUT");
		resp.addHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
		filterChain.doFilter(request, resp);
		//HttpServletRequest req = (HttpServletRequest) request;
/*		LOGGER.info("the remote address is {}.", req.getRemoteAddr());
		LOGGER.info("the remote address is {}.");

		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			LOGGER.info("headerName : {},  value:  {}", headerName, req.getHeader(headerName));
		}*/
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
