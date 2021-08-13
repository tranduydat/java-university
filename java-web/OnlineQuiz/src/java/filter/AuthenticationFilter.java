/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-06-16    1.0        DatDuyTran       Release 1.0<br>
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author datdu
 */
public class AuthenticationFilter implements Filter {

    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;

    // list login require urls
    private final String[] loginRequiredURLs = {
        "/home", " /make-quiz", "/manage-quiz", "/take-quiz"
    };

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public AuthenticationFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        
        // Check if user is logged in or not
        boolean isLoggedIn = (session.getAttribute("accountlogged") != null);
        
        // Get uri of login page
        String loginURI = httpRequest.getContextPath() + "/login";
        
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        
        if (isLoggedIn && isLoginRequest) {
            // the user is already logged in and he's trying to login again
            // then forward to the homepage
            httpResponse.sendRedirect("home");
        } else if (!isLoggedIn && isLoginRequired()) {
            // The user is not logged in, and the requested page requires
            // authentication, then forward to the login page
            httpResponse.sendRedirect("login");
        } else {
            // For other requested pages that do not require authentication
            // or the user is already logged in, continue to the destination
            chain.doFilter(request, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     *
     * @return
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
    }

    private boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();
        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
        return false;
    }
}
