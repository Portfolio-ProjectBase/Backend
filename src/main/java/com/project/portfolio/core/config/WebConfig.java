package com.project.portfolio.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Tüm URL'ler için CORS yapılandırması yapılır
                .allowedOrigins("*") // Tüm kaynaklardan gelen isteklere izin verilir
                .allowedMethods("GET", "POST", "PUT", "DELETE") // İzin verilen HTTP yöntemleri belirlenir
                .allowedHeaders("*")
                ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/resumes/**")
                .addResourceLocations("file:uploads/resumes/");
    }

}
