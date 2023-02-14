package ds.spring.gradle.config;

import lombok.extern.slf4j.Slf4j;
import org.mx.spring.config.SpringRedisConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource({
        "classpath:redis.properties"
})
@Import({
        SpringRedisConfig.class,
})
@Slf4j
public class DsRedisConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("DsRedisConfig 开始加载");
    }

}
