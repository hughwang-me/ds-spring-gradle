package ds.spring.gradle.config;

import lombok.extern.slf4j.Slf4j;
import org.mx.dal.config.DalHibernateConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource({
        "classpath:database.properties",
        "classpath:jpa.properties"
})

@Import({
        DalHibernateConfig.class
})
@EnableJpaRepositories({
        "ds.spring.gradle.repository"
})

@Slf4j
public class DsDalHibernateConfig implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("开始初始化 DAL 配置");
    }
}
