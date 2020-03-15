package com.a7z.sevenzgame.configuration;

import com.a7z.sevenzgame.utils.UploadUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 设置上传的路径可以被访问
 * @author lq
 * @create 2020/3/14-13:54
 */
@Configuration
public class UploadFilePathConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/"+ UploadUtil.getUploadFilePath()+"/upload/");

    }


}
