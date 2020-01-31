package club.zby.wuhan.bean;

import club.zby.wuhan.HttpRequestMethod.HttpProcessor.NationalCityByHttp;
import club.zby.wuhan.HttpRequestMethod.HttpProcessor.NationalSituationByHttp;
import club.zby.wuhan.Spider.SpiderProcessor.NationalSituationBySpider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public enum ScheduledTaskEnum {

    /**
     * 任务1（全国状况）
     * 爬取疫情实时数据 全国的确诊、治愈、死亡人数
     */
    TASK_01("NationalSituationByHttp",new NationalSituationByHttp()),
    TASK_02("NationalSituationBySpider",new NationalSituationBySpider()),
    TASK_03("NationalCityByHttp",new NationalCityByHttp());

    /**
     * 定时任务key
     */
    private String taskKey;
    /**
     * 定时任务 执行实现类
     */
    private Runnable scheduledTaskJob;

    ScheduledTaskEnum(String taskKey, Runnable scheduledTaskJob) {
        this.taskKey = taskKey;
        this.scheduledTaskJob = scheduledTaskJob;
    }

    /**
     * 初始化 所有任务
     */
    public static Map<String, Runnable> initScheduledTask() {
        if (ScheduledTaskEnum.values().length < 0) {
            return new ConcurrentHashMap<String, Runnable>();
        }
        Map<String, Runnable> scheduledTaskJobMap = new ConcurrentHashMap<String, Runnable>();
        for (ScheduledTaskEnum taskEnum : ScheduledTaskEnum.values()) {
            scheduledTaskJobMap.put(taskEnum.taskKey, taskEnum.scheduledTaskJob);
        }

        return scheduledTaskJobMap;
    }
}
