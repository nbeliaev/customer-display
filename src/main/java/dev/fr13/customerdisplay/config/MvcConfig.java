package dev.fr13.customerdisplay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Value("${upload.path.prefix}")
    private String uploadPathPrefix;
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/ads/**")
                .addResourceLocations(uploadPathPrefix + uploadPath + File.separator);
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
