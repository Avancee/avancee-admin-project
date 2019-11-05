package com.github.avancee.admin.security.handler;

import com.alibaba.fastjson.JSON;
import com.github.avancee.admin.util.RestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthExceptionEntryPoint
 *
 * @author byference
 * @since 2019-11-05
 */
@Slf4j
public class DefaultAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSON.toJSONString(RestBody.fail(authException.getMessage())));
        } catch (IOException e) {
            log.error("AuthExceptionEntryPoint : ", e);
        }
    }

}
