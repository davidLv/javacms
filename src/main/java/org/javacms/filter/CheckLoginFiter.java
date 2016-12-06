package org.javacms.filter;

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

public class CheckLoginFiter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
            throw new ServletException("The request and response object are not the instance of HttpServletRequest and HttpServletResponse");
        }
        
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(true);
        
        Object userId =  session.getAttribute("userId");
        Object userName = session.getAttribute("userName");
        
        if ((userId == null) || (userName == null)) {
            httpResponse.sendRedirect("/javacms/admin/index");
            return;
        } /*else {
            httpResponse.sendRedirect("/javacms/admin/main");
        }*/
        //filterChain.doFilter(servletRequest, servletResponse);
        return;
        

    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
