package club.zby.wuhan.bean;

import club.zby.wuhan.HttpRequestMethod.HttpMethodProcessor.DataInit;
import club.zby.wuhan.HttpRequestMethod.HttpMethodProcessor.NationalCity1ByHttp;
import club.zby.wuhan.HttpRequestMethod.HttpMethodProcessor.NationalCity2ByHttp;
import club.zby.wuhan.HttpRequestMethod.HttpMethodProcessor.NationalSituationByHttp;
import club.zby.wuhan.Spider.SpiderProcessor.NationalSituationBySpider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public enum ScheduledTaskEnum {

    /**
     * 任务1（全国状况）
     * 获取疫情实时数据 全国的确诊、治愈、死亡人数（Http）
     */
    TASK_01("NationalSituationByHttp",new NationalSituationByHttp()),
    /**
     * 任务2（全国状况）
     * 获取疫情实时数据 全国的确诊、治愈、死亡人数（Spider）
     */
    TASK_02("NationalSituationBySpider",new NationalSituationBySpider()),
    /**
     * 任务3（全国各省市状况）
     * 获取疫情实时数据 全国各省市的确诊、治愈、死亡人数（Http）
     */
    TASK_03("NationalCity1ByHttp",new NationalCity1ByHttp()),
    /**
     * 任务4（全国各省市状况）
     * 获取疫情实时数据 全国各省市的确诊、治愈、死亡人数（Http）
     */
    TASK_04("NationalCity2ByHttp",new NationalCity2ByHttp()),
    /**
     * 任务5
     * 全量数据初始化，执行前会清空表中所有数据
     */
    TASK_05("DataInit",new DataInit());
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
