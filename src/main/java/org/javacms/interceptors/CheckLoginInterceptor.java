package org.javacms.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

    private final Logger log = Logger.getLogger(CheckLoginInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String userName = (String) request.getSession().getAttribute("userName");
        if (userName == null) {
            log.info("The user does not login yet");
            request.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(request, response);
            //response.sendRedirect("/admin/");
            return false;
            //modelAndView.setViewName("/admin/login");
        } else {
            log.info("The user already login, so redirect to backend index page");
            //response.sendRedirect("/javacms/admin/index");
            return true;
        }
        //return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        /*String userName = (String) request.getSession().getAttribute("userName");
        if (userName == null) {
            log.info("The user does not login yet");
            modelAndView.setViewName("/admin/login");
        } else {
            log.info("The user already login, so redirect to backend index page");
            response.sendRedirect("/javacms/admin/index");
        }*/
        // TODO Auto-generated method stub
        //super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }
    
}
