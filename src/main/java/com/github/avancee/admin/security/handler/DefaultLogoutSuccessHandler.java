package com.github.avancee.admin.security.handler;

import com.alibaba.fastjson.JSON;
import com.github.avancee.admin.util.RestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * DefaultLogoutSuccessHandler
 *
 * @author byference
 * @since 2019-11-10
 */
@Slf4j
public class DefaultLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSON.toJSONString(RestBody.ok()));
        } catch (IOException e) {
            log.error("AuthExceptionEntryPoint : ", e);
        }
    }

}
