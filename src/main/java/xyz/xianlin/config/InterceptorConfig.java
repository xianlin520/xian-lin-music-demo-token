package xyz.xianlin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.xianlin.controller.interceptor.JwtInterceptor;

@Configuration//定义此类为配置类
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns拦截的路径
        String[] addPathPatterns = {
                // 拦截所有请求，通过判断是否有 @JwtIgnore 注解来进行排除
                "/**"
        };
        //excludePathPatterns排除的路径
        String[] excludePathPatterns = {
                // 排除users路径
                "/users/**", "/token/**", "/users", "/pages/**"
        };
        //创建用户拦截器对象并指定其拦截的路径和排除的路径
        registry.addInterceptor(new JwtInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}

