package com.demo.filter;

import javax.servlet.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.demo.model.User;




/**
 * session过期
 * 
 * @author
 *
 */
public class SessionTimeOutFilter  implements Filter{
	
	static Log logger = LogFactory.getLog(SessionTimeOutFilter.class);
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession sess = req.getSession();
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//不加上此句，action中乱码
		User user = (User)sess.getAttribute("loggedUser");
		
		if (user == null || user.getName() == null) {
			logger.debug("session过期，请重新登录！");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
		} else {
				chain.doFilter(request, response);
		}
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {

	}
	

}
