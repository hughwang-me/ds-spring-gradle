package ds.spring.gradle.task;

import ds.spring.gradle.service.Task1JobService;
import ds.spring.gradle.service.Task2JobService;
import lombok.extern.slf4j.Slf4j;
import org.mx.spring.task.BaseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Task2 extends BaseTask {

    private Task2JobService task2JobService;

    @Autowired
    public Task2(Task2JobService task2JobService) {
        this.task2JobService = task2JobService;
    }

    @Override
    public void invoke() {
        log.warn("执行任务2");
        task2JobService.run();
    }
}
