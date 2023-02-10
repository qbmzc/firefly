package com.cong.firefly.common;

import javax.print.attribute.standard.Media;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cong
 * @date 2023/1/17 14:13
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/**",
                        "/actuator/**");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders(HttpHeaders.CONTENT_TYPE,
                        HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                        HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                        HttpHeaders.ACCEPT,
                        HttpHeaders.ORIGIN)
                .allowedMethods("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true);
    }

}
