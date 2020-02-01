package club.zby.wuhan.ScheduledTask.ScheduledTaskService;

import club.zby.wuhan.ScheduledTask.ScheduledTaskDao.ScheduledTaskDao;
import club.zby.wuhan.bean.ScheduledTaskBean;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantLock;


@Service
public class ScheduledTaskServiceImpl implements ScheduledTaskService {

    @Autowired
    private ScheduledTaskDao scheduledTaskDao;
    /**
     * 可重入锁
     */
    private ReentrantLock lock = new ReentrantLock();
    @Autowired
    @Qualifier(value = "scheduledTaskJobMap")
    private Map<String, Runnable> scheduledTaskJobMap;

    @Qualifier(value = "threadPoolTaskScheduler")
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    /**
     * 存放已经启动的任务map
     */
    private Map<String, ScheduledFuture> scheduledFutureMap = new ConcurrentHashMap<String, ScheduledFuture>();
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskServiceImpl.class);

    /**
     * 所有任务列表
     */
    public List<ScheduledTaskBean> taskList() {
        logger.info(">>>>>> 获取数据库任务列表 >>>>>> ");
        List<ScheduledTaskBean> taskBeanList = scheduledTaskDao.getAllNeedStartTask();
        if (CollectionUtils.isEmpty(taskBeanList)) {
            return new ArrayList<ScheduledTaskBean>();
        }

        for (ScheduledTaskBean taskBean : taskBeanList) {
            String taskKey = taskBean.getTaskKey();
            //是否启动标记处理
            taskBean.setStartFlag(this.isStart(taskKey));
        }
        logger.info(">>>>>> 获取任务列表结束 >>>>>> ");
        return taskBeanList;
    }
    /**
     * 根据任务key 启动任务
     */
    public Boolean start(String taskKey) {
        logger.info(">>>>>> 启动任务 {} 开始 >>>>>>", taskKey);
        //添加锁放一个线程启动，防止多人启动多次
        lock.lock();
        logger.info(">>>>>> 添加任务启动锁完毕");
        try {
            //校验是否已经启动
            if (this.isStart(taskKey)) {
                logger.info(">>>>>> 当前任务已经启动，无需重复启动！");
                return false;
            }
            //校验任务是否存在
            if (!scheduledTaskJobMap.containsKey(taskKey)) {
                return false;
            }
            //根据key数据库获取任务配置信息
            ScheduledTaskBean scheduledTask = scheduledTaskDao.getByKey(taskKey);
            //启动任务
            this.doStartTask(scheduledTask);
        } finally {
            // 释放锁
            lock.unlock();
            logger.info(">>>>>> 释放任务启动锁完毕");
        }
        logger.info(">>>>>> 启动任务 {} 结束 >>>>>>", taskKey);
        return true;
    }
    /**
     * 根据任务key 停止任务
     */
    public Boolean stop(String taskKey) {
        logger.info(">>>>>> 进入停止任务 {}  >>>>>>", taskKey);
        //当前任务实例是否存在
        boolean taskStartFlag = scheduledFutureMap.containsKey(taskKey);
        logger.info(">>>>>> 当前任务实例是否存在 {}", taskStartFlag);
        if (taskStartFlag) {
            //获取任务实例
            ScheduledFuture scheduledFuture = scheduledFutureMap.get(taskKey);
            //关闭实例
            scheduledFuture.cancel(true);
        }
        logger.info(">>>>>> 结束停止任务 {}  >>>>>>", taskKey);
        return taskStartFlag;
    }
    /**
     * 根据任务key 重启任务
     */
    public Boolean restart(String taskKey) {
        logger.info(">>>>>> 进入重启任务 {}  >>>>>>", taskKey);
        //先停止
        this.stop(taskKey);
        //再启动
        return this.start(taskKey);
    }
    /**
     * 程序启动时初始化  ==> 启动所有正常状态的任务
     */
    public void initAllTask(List<ScheduledTaskBean> scheduledTaskBeanList) {
        logger.info("程序启动 ==> 初始化所有任务开始 ！size={}", scheduledTaskBeanList.size());
        if (CollectionUtils.isEmpty(scheduledTaskBeanList)) {
            return;
        }
        for (ScheduledTaskBean scheduledTask : scheduledTaskBeanList) {
            //任务 key
            String taskKey = scheduledTask.getTaskKey();
            //校验是否已经启动
            if (this.isStart(taskKey)) {
                continue;
            }
            //启动任务
            this.doStartTask(scheduledTask);
        }
        logger.info("程序启动 ==> 初始化所有任务结束 ！size={}", scheduledTaskBeanList.size());
    }
    /**
     * 打印正在启动的任务
     */
    public String printlnTask() {
        logger.info("当前启动的任务项 size {}", scheduledFutureMap.size());
        String printlnTask = JSON.toJSONString(scheduledFutureMap);
        logger.info("当前启动的任务项 {}", printlnTask);
        return printlnTask;
    }
    /**
     * 执行启动任务
     */
    private void doStartTask(ScheduledTaskBean scheduledTask) {
        //任务key
        String taskKey = scheduledTask.getTaskKey();
        //定时表达式
        final String taskCron1 = scheduledTask.getTaskCron();
        //获取需要定时调度的接口
        Runnable scheduledTaskJob = scheduledTaskJobMap.get(taskKey);
        logger.info(">>>>>> 任务 [ {} ] ,启动周期cron={}", scheduledTask.getTaskDesc(), taskCron1);
        ScheduledFuture scheduledFuture = threadPoolTaskScheduler.schedule(scheduledTaskJob,
                new Trigger() {
                    @Override
                    public Date nextExecutionTime(TriggerContext triggerContext) {
                        CronTrigger cronTrigger = new CronTrigger(taskCron1);
                        return cronTrigger.nextExecutionTime(triggerContext);
                    }
                });
        //将启动的任务放入 map
        scheduledFutureMap.put(taskKey, scheduledFuture);
    }
    /**
     * 任务是否已经启动
     */
    private Boolean isStart(String taskKey) {
        //校验是否已经启动
        if (scheduledFutureMap.containsKey(taskKey)) {
            if (!scheduledFutureMap.get(taskKey).isCancelled()) {
                return true;
            }
        }
        return false;
    }
}
