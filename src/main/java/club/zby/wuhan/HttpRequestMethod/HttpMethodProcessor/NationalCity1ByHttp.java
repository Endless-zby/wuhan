package club.zby.wuhan.HttpRequestMethod.HttpMethodProcessor;

import club.zby.wuhan.HttpRequestMethod.HttpMethod.HttpMethodImpl;
import club.zby.wuhan.HttpRequestMethod.HttpMethodService.HttpMethodDao;
import club.zby.wuhan.ScheduledTask.ScheduledTaskService.ScheduledTaskServiceImpl;
import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import club.zby.wuhan.bean.EpidemicBean.NationalEpidemicBean;
import club.zby.wuhan.bean.EpidemicBean.ProvinceEpidemicBean;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/31 20:03
 */
public class NationalCity1ByHttp implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTaskServiceImpl.class);


    @Override
    public void run() {

        try {
            //获取全国各省市的数据
            HttpMethodImpl httpMethod = new HttpMethodImpl();
            String healingPos = httpMethod.getHealingCity1();
            NationalEpidemicBean nationalEpidemicBean = JSON.parseObject(healingPos, NationalEpidemicBean.class);
            List<ProvinceEpidemicBean> list = nationalEpidemicBean.getList();
            ArrayList<CityEpidemicBean> cityEpidemicBeans = new ArrayList<>();

            for (ProvinceEpidemicBean provinceEpidemicBean: list) {
                cityEpidemicBeans.addAll(provinceEpidemicBean.getList());
            }
            NationalCity nationalCity = new NationalCity();
            List<CityEpidemicBean> cityEpidemicBeans2 = nationalCity.saveAll(cityEpidemicBeans);
//            List<CityEpidemicBean> cityEpidemicBeans1 = nationalCity.saveAll(cityEpidemicBeans);

            logger.info("保存数据量：[{}] 条",cityEpidemicBeans2.size());
            logger.info("返回报文体：{}", nationalEpidemicBean.toString());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
