package club.zby.wuhan.Spider.SpiderProcessor;

import club.zby.wuhan.Config.HttpRequest;
import club.zby.wuhan.ScheduledTask.ScheduledTaskService.ScheduledTaskServiceImpl;
import club.zby.wuhan.Spider.Run.Run;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/30 16:39
 * 解析待爬取的页面  -->
 * https://broccoli.uc.cn/apps/pneumonia/routes/index?uc_param_str=dsdnfrpfbivesscpgimibtbmnijblauputogpintnwktprchmt
 */
public class NationalSituationBySpider extends Run implements Runnable   {


    private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskServiceImpl.class);

    public void run() {

        logger.info("爬虫启动，爬取中。。。");

    }

}
