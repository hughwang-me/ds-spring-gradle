package ds.spring.gradle.config;

import ds.spring.gradle.restful.HomeResource;
import ds.spring.gradle.restful.DbResource;
import lombok.extern.slf4j.Slf4j;
import org.mx.service.server.config.ServerConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource({
        "classpath:server.properties"
})
@Import({
        ServerConfig.class
})
@Slf4j
public class DsServiceConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("DsServiceConfig 开始加载");
    }

    @Bean("restfulClasses")
    public List<Class<?>> restfulClassesTest() {
        return Arrays.asList(HomeResource.class, DbResource.class);
    }

}
