package com.ep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 全局跨域配置
 */
@Configuration
public class GlobalCorsConfig {
    /**
     * 跨域配置
     * @return
     */
    private CorsConfiguration corsConfiguration(){
        CorsConfiguration config = new CorsConfiguration();
        // 允许跨域访问的域名
        config.addAllowedOrigin("*");
        // 请求头
        config.addAllowedHeader("*");
        // 请求方法
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.DELETE);
        config.addAllowedMethod(HttpMethod.OPTIONS);
        // 预检请求的有效期，单位为秒。
        config.setMaxAge(3600L);
        // 允许接受cookie
        config.setAllowCredentials(true);

        return config;
    }

    /**
     * 注册跨域过滤器
     * @return
     */
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", this.corsConfiguration());
        CorsFilter corsFilter = new CorsFilter(source);
        return corsFilter;
    }

}
