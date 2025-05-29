package com.project.portfolio.core.config;

import com.project.portfolio.core.interceptor.RequestLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private RequestLoggingInterceptor requestLoggingInterceptor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Tüm URL'ler için CORS yapılandırması yapılır
                .allowedOrigins("https://denizkiritoglu.com", "https://www.denizkiritoglu.com", "https://api.denizkiritoglu.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE") // İzin verilen HTTP yöntemleri belirlenir
                .allowedHeaders("*")
                ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/resumes/**")
                .addResourceLocations("file:uploads/resumes/");
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLoggingInterceptor)
                .addPathPatterns("/api/**"); // Sadece belirli path'lerde çalıştırmak için
    }

}
