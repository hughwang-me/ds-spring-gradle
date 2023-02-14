package ds.spring.gradle.service.impl;

import ds.spring.gradle.service.Task1JobService;
import ds.spring.gradle.service.Task2JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Task2JobServiceImpl implements Task2JobService , InitializingBean {

    @Override
    public void run() {
        log.warn("开始执行任务 【2】");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("Task [2] JobServiceImpl 初始化成功");
    }
}
