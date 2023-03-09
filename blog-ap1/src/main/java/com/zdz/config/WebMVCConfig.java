package com.zdz.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置：前端启动端口8080，后端启动端口8888，两个域名之间访问，浏览器会有跨域问题
         registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }
}
