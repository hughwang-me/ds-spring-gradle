package ds.spring.gradle.config;

import lombok.extern.slf4j.Slf4j;
import org.mx.spring.config.SpringConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.*;

@Configuration
@Import({
        SpringConfig.class
})
@ComponentScan({
        "ds.spring.gradle"
})

@Slf4j
public class AppConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("AppConfig 开始加载");
    }

}
