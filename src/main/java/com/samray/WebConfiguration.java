package com.samray;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/11/17
 *         允许前端的vue进行跨越请求
 *         CORS support for vue request
 */
@EnableWebMvc
@Configuration
public class WebConfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter() {
        @Override
            public void addCorsMappings(CorsRegistry registry){
          registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("*");
        }
        };
    }
}
