package ds.spring.gradle.service.impl;

import ds.spring.gradle.service.Task1JobService;
import ds.spring.gradle.service.TestRedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.mx.spring.utils.SpringContextHolder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Date;

@DependsOn("task2JobServiceImpl")
@Service
@Slf4j
public class Task1JobServiceImpl implements Task1JobService , InitializingBean {

    private TestRedisService redisService;

    @Autowired
    public Task1JobServiceImpl(TestRedisService redisService) {
        this.redisService = redisService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("Task [1] JobServiceImpl 初始化成功");
    }

    @Override
    public void run() {
        log.warn("开始执行任务 【1】");

        Task2JobServiceImpl task2JobService = SpringContextHolder.getBean(Task2JobServiceImpl.class);
        task2JobService.run();

        redisService.add("wanghuan" , "time:" + System.currentTimeMillis());
    }


}
