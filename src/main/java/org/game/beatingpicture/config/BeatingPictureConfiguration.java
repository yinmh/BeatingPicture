package org.game.beatingpicture.config;

import org.game.beatingpicture.intercepter.UserInfoIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BeatingPictureConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    //配置拦截器
    public void addInterceptors(InterceptorRegistry registry){
        //registry.addInterceptor此方法添加拦截器
        registry.addInterceptor(userInfoIntercepter()).addPathPatterns("/index","user/addUserInfo");
    }

    @Bean
    UserInfoIntercepter userInfoIntercepter(){
        return new UserInfoIntercepter();
    }


    /*@Bean
    public FilterRegistrationBean shiroAuthcFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ShiroAuthcFilter());
        registration.addUrlPatterns("/user/**"); //
        registration.addUrlPatterns("/org/**"); //
        registration.addUrlPatterns("/role/**"); //
        registration.addUrlPatterns("/menu/**"); //
        registration.addUrlPatterns("/log/**"); //
        registration.addUrlPatterns("/index"); //
        return registration;
    }*/

}