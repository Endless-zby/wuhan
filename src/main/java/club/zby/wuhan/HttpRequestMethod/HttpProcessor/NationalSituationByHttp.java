package club.zby.wuhan.HttpRequestMethod.HttpProcessor;

import club.zby.wuhan.Config.ExtMappingJackson2HttpMessageConverter;
import club.zby.wuhan.Config.HttpRequest;
import club.zby.wuhan.Config.HttpRequestImpl;
import club.zby.wuhan.HttpRequestMethod.HttpInterface.HttpMethodImpl;
import club.zby.wuhan.ScheduledTask.ScheduledTaskService.ScheduledTaskServiceImpl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/31 18:32
 * 模拟请求直接通过夸克的接口获取信息
 */
public class NationalSituationByHttp implements Runnable  {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskServiceImpl.class);

    @Override
    public void run() {
        try {
            HttpMethodImpl httpMethod = new HttpMethodImpl();
            String healingPos = httpMethod.getHealingPos();
            Map map = JSON.parseObject(healingPos, Map.class);

            //获取全国信息
            ArrayList<List<String>> lists = new ArrayList<List<String>>();

            logger.info("返回报文体：{}", map);
            logger.info("返回报文体：{}", map.get("colums"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
