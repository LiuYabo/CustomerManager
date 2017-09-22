package edu.xidian.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {

    public LoginFilter() {

    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest srequest = (HttpServletRequest) request;
		HttpServletResponse sresponse= (HttpServletResponse) response;
		HttpSession session = srequest.getSession();
		String url = srequest.getRequestURI();
		System.out.println("this is filter");
		
		if (url.endsWith("cusmang/")|| url.endsWith("index.jsp") ||  url.endsWith("Login.jsp") || url.endsWith("Login2.jsp")) {

			chain.doFilter(request, response);
			return;
		} else if (session == null ||session.getAttribute("customer") == null) {
			sresponse.sendRedirect("/cusmang/Login.jsp");
			
			return;
		} else {
			chain.doFilter(request, response);
			}
		
		
		
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
