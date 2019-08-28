package fr.formation.inti.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet Filter implementation class ConnexionFilter
 */
@WebFilter(filterName="connexionFilter", dispatcherTypes = {DispatcherType.FORWARD })
public class ConnexionFilter implements Filter {
	private static final Log log = LogFactory.getLog(ConnexionFilter.class);

    /**
     * Default constructor. 
     */
    public ConnexionFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
//		if () {
		// pass the request along the filter chain
		chain.doFilter(request, response);
//		}
//		else () {
//		
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
