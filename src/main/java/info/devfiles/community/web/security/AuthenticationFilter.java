package info.devfiles.community.web.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
	
	private static final String AUTH_COOKIE_NAME = "SESSIONID";

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			String requestURI = httpRequest.getRequestURI();
			
			if (requestURI.startsWith("/myaccount")) {
				Cookie authCookie = getCookieByName(httpRequest.getCookies(), AUTH_COOKIE_NAME);
				if (authCookie != null) {
					
				}
			}
			
		}
		
	}
	
	private Cookie getCookieByName(Cookie[] cookies, String name) {
		if (cookies != null && name != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
