package club.zby.wuhan.HttpRequestMethod.HttpMethodProcessor;

import club.zby.wuhan.Config.ApplicationBean;
import club.zby.wuhan.Config.IdWorker;
import club.zby.wuhan.HttpRequestMethod.HttpMethodService.QiXiangDao;
import club.zby.wuhan.bean.QiXiang;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;


/**
 * @Author: 赵博雅
 * @Date: 2020/5/25 14:06
 */
public class NationalHuanJing implements Runnable  {

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(NationalHuanJing.class);


    @Override
    public void run() {

        ArrayList<String> citycCodeList = new ArrayList<String>();
        try {
            File file = ResourceUtils.getFile("classpath:code.txt");
            FileReader f_reader = new FileReader(file);
            BufferedReader reader = new BufferedReader(f_reader);
            String str = reader.readLine();
            while (str != null) {
                String citycode = str.substring(0,9);
                citycCodeList.add(citycode);
                str = reader.readLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        QiXiangDao qiXiangDao = ApplicationBean.getBean(QiXiangDao.class);
        IdWorker idWorker = ApplicationBean.getBean(IdWorker.class);
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(60000).setConnectTimeout(60000)
                .setConnectionRequestTimeout(60000)
                .setStaleConnectionCheckEnabled(true).build();
        // 创建httpClient对象
        CloseableHttpClient h = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig).build();

        for (String citycode : citycCodeList) {
            // 创建并设置URI
            URIBuilder uri = null;
            // 创建Get请求
            HttpGet hg = null;
            String url = "";
            // 创建响应对象
            CloseableHttpResponse response = null;
            InputStream inputstream = null;

            try {
                url = "http://d1.weather.com.cn/sk_2d/" + citycode + ".html?_="
                        + System.currentTimeMillis();
                uri = new URIBuilder(url);
                hg = new HttpGet(uri.build());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            // 设置请求头
            hg.setHeader("Accept",
                    "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            hg.setHeader("Accept-Encoding", "gzip, deflate");
            hg.setHeader("Accept-Language",
                    "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
            hg.setHeader("Cache-Control", "no-cache");
            hg.setHeader("Connection", "keep-alive");
            hg.setHeader("Host", "d1.weather.com.cn");
            hg.setHeader("Upgrade-Insecure-Requests", "1");
            hg.setHeader("Cookie",
                    "f_city=%E9%83%91%E5%B7%9E%7C101180101%7C; Hm_"
                            + "lvt_080dabacb001ad3dc8b9b9049b36d"
                            + "43b=1546482322; Hm_lpvt_080dabacb001a");
            hg.setHeader(
                    "User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
            hg.setHeader("Referer",
                    "http://www.weather.com.cn/weather1dn/101180101.shtml");
            // 发送请求
            HttpEntity entity = null;
            String line = "";
            String Sline = "";

            try {
                response = h.execute(hg);
                // 获取请求结果
                entity = response.getEntity();
                inputstream = entity.getContent();
                BufferedReader bufferedreader = new BufferedReader(
                        new InputStreamReader(inputstream, "UTF-8"));
                while ((line = bufferedreader.readLine()) != null) {

                    Sline += line + "\n";
                }

                Sline = Sline.substring(Sline.indexOf('{'));
                String replace = Sline.replace("SD", "SD1");

                QiXiang qiXiang = JSON.parseObject(replace, QiXiang.class);
                qiXiang.setId(idWorker.nextId() + "");
                QiXiang save = qiXiangDao.save(qiXiang);
                System.out.println("更新数据：" + save.getCityname());
                logger.info("写入成功！");


            } catch (ClientProtocolException e1) {
                // TODO Auto-generated catch block
                System.out.println("请求超时等问题");
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                System.out.println("I/O问题");
                e1.printStackTrace();
            } finally {
                try {
                    inputstream.close();
                    response.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    System.out.println("I/O、response流关闭");
                    e.printStackTrace();
                }
            }
        }



    }
}
