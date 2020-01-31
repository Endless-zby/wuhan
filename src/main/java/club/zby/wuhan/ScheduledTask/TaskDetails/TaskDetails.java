package club.zby.wuhan.ScheduledTask.TaskDetails;

import java.util.Map;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/30 18:00
 */
public interface TaskDetails {

    /**
     * 任务初始化
     * @return
     */
    public Map<String, Runnable> scheduledTaskJobMap();

}
