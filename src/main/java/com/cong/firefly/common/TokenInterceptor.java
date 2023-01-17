package com.cong.firefly.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author cong
 * @date 2023/1/17 13:54
 */
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            R r = new R(1130, "token不存在");
            renderString(response, r);
            return false;
        }
        String userStr = String.valueOf(request.getSession().getAttribute(token));
        log.info(userStr);
        if (StringUtils.isBlank(userStr)) {
            R r = new R(1131, "登陆超时");
            renderString(response, r);
            return false;
        }
        return true;
    }

    private static void renderString(HttpServletResponse response, R r) {
        try {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().print(ObjectMapperEnum.INSTANCE.getObjectMapper().writeValueAsString(r));
        } catch (IOException e) {
            log.error("io异常 {}", e.getMessage(), e);
        }

    }
}
