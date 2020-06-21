package com.example.board_image.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class GlobalConfig implements WebMvcConfigurer {

    private final String basePath;
    private final String[] localPath;

    public GlobalConfig(@Value("${local.image.base}") String basePath,
        @Value("${upload.image.foldername}") String[] localPath) {
        this.basePath = basePath;
        this.localPath = localPath;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        for (var path : localPath) {
            registry.addResourceHandler("/image/" + path + "/**")
                .addResourceLocations("file:///" + basePath + "/" + path + "/");
        }

    }
}
