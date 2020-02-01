package club.zby.wuhan.HttpRequestMethod.HttpMethodProcessor;

import club.zby.wuhan.HttpRequestMethod.HttpMethodService.HttpMethodDao;
import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/1 22:02
 */
@Component
public class NationalCity {

    @Autowired
    private HttpMethodDao httpMethodDao;

    public List<CityEpidemicBean> saveAll(List<CityEpidemicBean> cityEpidemicBeans){
        return httpMethodDao.saveAll(cityEpidemicBeans);
    }
}
