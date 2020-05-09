package com.ep;

import com.ep.config.UserLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootApplication
@Configuration
@EnableCaching
public class Application extends WebMvcConfigurerAdapter {
    @Resource
    private UserLoginInterceptor userLoginInterceptor;

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        //添加对用户是否登录的拦截器，并添加过滤项、排除项
        registry.addInterceptor(userLoginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/js/**", "/img/**", "/fonts/**", "/images/**", "/favicon.ico", "/font-awesome/**", "/LESS/**")//排除样式、脚本、图片等资源文件
                .excludePathPatterns("/")//排除登录页面
                .excludePathPatterns("/login")//排除登录操作
                .excludePathPatterns("/register");//排除注册操作
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
