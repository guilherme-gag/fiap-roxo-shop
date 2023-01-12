package com.roxo.roxoservproduct.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SwaggerUiWebMvcConfigurer implements WebMvcConfigurer {
    private final String baseUrl;
    public SwaggerUiWebMvcConfigurer(
            @Value("${springfox.documentation.swagger-ui.base-url:}") String baseUrl) {
        this.baseUrl = baseUrl;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
        registry.
                addResourceHandler(baseUrl + "/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(baseUrl + "/swagger-ui/")
                .setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/api/pet")
                .allowedOrigins("http://editor.swagger.io");
        registry
                .addMapping("/v2/api-docs.*")
                .allowedOrigins("http://editor.swagger.io");

//       registry
//               .addMapping("/**");

//       registry
//               .addMapping("/**")
//               .allowedOrigins("http://localhost:3000")
//               .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//
//       registry
//               .addMapping("/**")
//               .allowedOrigins("https://viniroxo.github.io/fiap-note/")
//               .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");

    }
}
