package com.samray.security.auth.ajax;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samray.common.WebUtil;
import com.samray.security.exception.AuthMethodNotSupportedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 2/7/17
 */
public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter{
    private static Logger logger= LoggerFactory.getLogger(AjaxLoginProcessingFilter.class);

    private final AuthenticationSuccessHandler successHandler;
    private final AuthenticationFailureHandler failureHandler;
    private final ObjectMapper objectMapper;
    public AjaxLoginProcessingFilter(String defaultProcessUrl, AuthenticationSuccessHandler successHandler,
                                     AuthenticationFailureHandler failureHandler, ObjectMapper objectMapper){
        super(defaultProcessUrl);
        this.successHandler=successHandler;
        this.failureHandler=failureHandler;
        this.objectMapper=objectMapper;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        if(!HttpMethod.POST.name().equals(httpServletRequest.getMethod())||!WebUtil.jsAjax(httpServletRequest)){
            if(logger.isDebugEnabled()){
                logger.debug("Authentication method not supported.Request method: "+httpServletRequest.getMethod());
            }
            throw new AuthMethodNotSupportedException("Authentication method not supported");
        }
        LoginRequest loginRequest=objectMapper.readValue(httpServletRequest.getReader(),LoginRequest.class);
        if(org.apache.commons.lang3.StringUtils.isBlank(loginRequest.getUsername())|| org.apache.commons.lang3.StringUtils.isBlank(loginRequest.getPassword())){
            throw  new AuthenticationServiceException("Username or Password not provided");
        }
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());
        return this.getAuthenticationManager().authenticate(token);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException,ServletException{
        successHandler.onAuthenticationSuccess(request,response,authResult);
    }
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,HttpServletResponse response,AuthenticationException failed) throws IOException,ServletException{
        SecurityContextHolder.clearContext();
        failureHandler.onAuthenticationFailure(request,response,failed);
    }
}
