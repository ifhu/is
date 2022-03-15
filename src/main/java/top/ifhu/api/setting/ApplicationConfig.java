package top.ifhu.api.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.ifhu.api.setting.Interceptor.GatewayIntercetor;

@Component
@Configurable
public class ApplicationConfig implements WebMvcConfigurer {

    @Autowired
    private GatewayIntercetor gatewayIntercetor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry
                .addInterceptor(gatewayIntercetor)
                .addPathPatterns("/**");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedMethods("GET","POST","OPTIONS","HEAD")
                .allowedOrigins(".fuhao.pub")
                .allowedHeaders("*");

    }

}
