package club.zby.wuhan.HttpRequestMethod.HttpProcessor;

import club.zby.wuhan.HttpRequestMethod.HttpInterface.HttpMethodImpl;
import club.zby.wuhan.ScheduledTask.ScheduledTaskService.ScheduledTaskServiceImpl;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/31 20:03
 */
public class NationalCityByHttp implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskServiceImpl.class);

    @Override
    public void run() {
        try {
            //获取全国各省市的数据
            HttpMethodImpl httpMethod = new HttpMethodImpl();
            String healingPos = httpMethod.getHealingCity1();
            Map map = JSON.parseObject(healingPos, Map.class);

            logger.info("返回报文体：{}", map);
            logger.info("返回报文体：{}", map.get("list"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
