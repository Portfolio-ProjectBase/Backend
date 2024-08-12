package com.project.portfolio.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    //Bu yapı ile dosyayı sunucuda belirli bir dizine kaydedip, oluşan URL'yi
    // veritabanında tutabilir ve gerektiğinde kullanıcıya bu URL üzerinden dosyayı indirebileceği bir link sunabilirsin.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/resumes/**")
                .addResourceLocations("file:uploads/resumes/");
    }
}
