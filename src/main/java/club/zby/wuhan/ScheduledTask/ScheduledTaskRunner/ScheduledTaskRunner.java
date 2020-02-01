package club.zby.wuhan.ScheduledTask.ScheduledTaskRunner;

import club.zby.wuhan.ScheduledTask.ScheduledTaskDao.ScheduledTaskDao;
import club.zby.wuhan.ScheduledTask.ScheduledTaskService.ScheduledTaskService;
import club.zby.wuhan.bean.ScheduledTaskBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(value = 1)
public class ScheduledTaskRunner implements ApplicationRunner {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTaskRunner.class);

    @Autowired
    private ScheduledTaskDao scheduledTaskDao;

    @Autowired
    private ScheduledTaskService scheduledTaskService;

    /**
     * 程序启动完毕后,需要自启的任务
     */
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.info(" >>>>>> 项目启动完毕, 获取所有需要启动的任务 开始!");
        List<ScheduledTaskBean> scheduledTaskBeanList = scheduledTaskDao.getAllNeedStartTask();
        scheduledTaskService.initAllTask(scheduledTaskBeanList);
        LOGGER.info(" >>>>>> 任务分配结束, 交由线程执行");
    }
}
