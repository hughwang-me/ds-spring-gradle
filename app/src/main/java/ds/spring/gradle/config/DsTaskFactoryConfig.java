package ds.spring.gradle.config;

import ds.spring.gradle.task.Task1;
import ds.spring.gradle.task.Task2;
import lombok.extern.slf4j.Slf4j;
import org.mx.spring.task.Task;
import org.mx.spring.task.TaskFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class DsTaskFactoryConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("DsTaskFactoryConfig 开始加载");
    }

    private Task1 task1;
    private Task2 task2;

    @Autowired
    public DsTaskFactoryConfig(Task1 task1, Task2 task2) {
        this.task1 = task1;
        this.task2 = task2;
    }

    @Bean
    public TaskFactory taskFactory() {
        log.warn("初始化任务 TaskFactory ");
        TaskFactory taskFactory = new TaskFactory();

        // 延迟 10 秒运行一次一个调度任务
        taskFactory.addScheduledTask(task1, new Task.ScheduledConfig(true, 10, TimeUnit.SECONDS));

        // 每 4 秒运行一次一个调度任务，运行前无延时
        taskFactory.addScheduledTask(task1, new Task.ScheduledConfig(false, 0, 4, TimeUnit.SECONDS));
        return taskFactory;
    }
}
