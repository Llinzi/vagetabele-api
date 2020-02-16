package com.vegetable.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName : WebConfig
 * @Description : 访问图片资源
 * @Author : 袁田婷
 * @Date: 2019-12-24 11:30
 */

/**
 * @Configuration用于定义配置类，可替换xml配置文件
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * "/img/users/**" 为图片访问路径（http://localhost:9000/img/users/user.jpg）
         * "file:E:/workspace/images/users/" 为图片在本地的路径（必须以 / 结尾）
         */
        registry.addResourceHandler("/img/users/**").addResourceLocations("file:E:/workspaces/images/users/");
        registry.addResourceHandler("/img/vegetable/**").addResourceLocations("file:E:/workspaces/images/vegetable/");
        registry.addResourceHandler("/img/menu/**").addResourceLocations("file:E:/workspaces/images/menu/");
    }
}
