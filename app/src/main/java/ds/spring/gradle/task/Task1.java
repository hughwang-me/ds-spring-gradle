package ds.spring.gradle.task;

import ds.spring.gradle.service.Task1JobService;
import lombok.extern.slf4j.Slf4j;
import org.mx.spring.task.BaseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Task1 extends BaseTask {

    private Task1JobService task1JobService;

    @Autowired
    public Task1(Task1JobService task1JobService) {
        this.task1JobService = task1JobService;
    }

    @Override
    public void invoke() {
        log.warn("执行任务1");
        task1JobService.run();
    }
}
