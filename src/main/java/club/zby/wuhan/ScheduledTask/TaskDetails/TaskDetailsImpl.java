package club.zby.wuhan.ScheduledTask.TaskDetails;

import club.zby.wuhan.ScheduledTask.ScheduledTaskService.ScheduledTaskServiceImpl;
import club.zby.wuhan.bean.ScheduledTaskEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Map;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/30 18:00
 */
@Configuration
public class TaskDetailsImpl implements TaskDetails {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskServiceImpl.class);

    /**
     * 初始化线程池
     * @return
     */
    @Bean(name = "threadPoolTaskScheduler")
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        logger.info("创建定时任务调度线程池 start");
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix("taskExecutor-");
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
        logger.info("创建定时任务调度线程池 end");
        return threadPoolTaskScheduler;
    }

    /**
     * 任务初始化所有任务
     * @return
     */
    @Bean(name = "scheduledTaskJobMap")
    public Map<String, Runnable> scheduledTaskJobMap() {
        return ScheduledTaskEnum.initScheduledTask();
    }
}
