package org.javacms.core.security.filter;

//import com.google.code.kaptcha.Constants;
import org.javacms.core.security.handler.CustomLoginSuccessHandler;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * Created by David-CB.Lv on 2017/2/23.
 */
@Component("customUsernamePasswordAuthenticationFilter")
//public class CustomUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(CustomUsernamePasswordAuthenticationFilter.class);

    private String validCodeParam = "j_code";

    public CustomUsernamePasswordAuthenticationFilter() {
        super.setFilterProcessesUrl("/admin/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String verifyCode = request.getParameter("j_code");
        /*String sessionVarifyCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (verifyCode.isEmpty() || !verifyCode.equals(sessionVarifyCode)) {
            logger.info("The Captcha is not valid");
            try {
                response.sendError(1001, "Captcha is not Valid");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                response.sendRedirect(request.getContextPath() + "/admin?error=CAPTCHA_INVALID");
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new BadCredentialsException("CAPTCHA:Captcha is not valid");

        }
*/
        return super.attemptAuthentication(request, response);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    @Autowired
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler customLoginSuccessHandler) {
        super.setAuthenticationSuccessHandler(customLoginSuccessHandler);
    }

    @Override
    @Autowired
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler customLoginFailHandler) {
        super.setAuthenticationFailureHandler(customLoginFailHandler);
    }


}
