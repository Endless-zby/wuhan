package club.zby.wuhan.HttpRequestMethod.HttpMethodProcessor;

import club.zby.wuhan.Config.ApplicationBean;
import club.zby.wuhan.HttpRequestMethod.HttpMethod.HttpMethodImpl;
import club.zby.wuhan.HttpRequestMethod.HttpMethodService.HttpMethodDao;
import club.zby.wuhan.ScheduledTask.ScheduledTaskService.ScheduledTaskServiceImpl;
import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import club.zby.wuhan.bean.EpidemicBean.NationalEpidemicBean;
import club.zby.wuhan.bean.EpidemicBean.ProvinceEpidemicBean;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 18:17
 */
public class DataInit implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(DataInit.class);
    @Override
    public void run() {
        try {
            HttpMethodDao httpMethodDao = ApplicationBean.getBean(HttpMethodDao.class);
            //获取全国各省市的数据
            HttpMethodImpl httpMethod = new HttpMethodImpl();
            String healingPos = httpMethod.getHealingCity1();
            NationalEpidemicBean nationalEpidemicBean = JSON.parseObject(healingPos, NationalEpidemicBean.class);
            List<ProvinceEpidemicBean> list = nationalEpidemicBean.getList();
            ArrayList<CityEpidemicBean> cityEpidemicBeans = new ArrayList<>();

            for (ProvinceEpidemicBean provinceEpidemicBean: list) {
                cityEpidemicBeans.addAll(provinceEpidemicBean.getList());
            }
            logger.info("本次插入数据量：[{}] 条",cityEpidemicBeans.size());
            if(httpMethodDao != null){
                logger.info("返回报文体：{}", nationalEpidemicBean.toString());
            }
            List<CityEpidemicBean> resCityEpidemicBean = httpMethodDao.saveAll(cityEpidemicBeans);

            logger.info("本次成功插入数据量：[{}] 条",resCityEpidemicBean.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
