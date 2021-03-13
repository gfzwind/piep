package com.petweb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Create By yushe on 2020/4/27
 */
@Configuration
public class ResourceConfigAdapter implements WebMvcConfigurer {
    @Value("${files.location.realconfig}")
    private String realLocation;
    @Value("${files.location.virtue}")
    private String virtueLocation;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {  //如果是Windows系统
            // 这里配置虚拟路径映射物理路径。把物理地址file:F:/petFiles/用/upload/地址代替了
            registry.addResourceHandler(virtueLocation).
                    addResourceLocations(realLocation);
        }else{//linux和mac系统
            registry.addResourceHandler(virtueLocation).
                    addResourceLocations("/petFiles/");
        }
    }
}
