package com.github.avancee.admin.security.handler;

import com.alibaba.fastjson.JSON;
import com.github.avancee.admin.util.RestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomAccessDeniedHandler
 *
 * @author byference
 * @since 2019-11-05
 */
@Slf4j
public class DefaultAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) {

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSON.toJSONString(RestBody.fail(accessDeniedException.getMessage())));
        } catch (IOException e) {
            log.error("AuthExceptionEntryPoint : ", e);
        }
    }

}
