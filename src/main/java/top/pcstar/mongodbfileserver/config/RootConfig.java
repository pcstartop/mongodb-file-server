package top.pcstar.mongodbfileserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: PanChao
 * @Description: ContextLoaderListener加载应用上下文时使用RootConfig配置类
 * @Date: Created in 9:25 2018/9/4
 */
@Configuration
@ComponentScan(basePackages = {"top.pcstar.mongodbfileserver"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setLocations(new ClassPathResource("config/application.properties"));
        return placeholderConfigurer;
    }
}
