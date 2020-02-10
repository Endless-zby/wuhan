package club.zby.wuhan.InternetFront.Service;

import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 19:12
 */
@Service
public interface WuHanService {
    /**
     * 查询各个区县市级的疫情情况
     * @return
     */
    List<CityEpidemicBean> cityEpidemic();

    /**
     * 根据城市编码查询所选城市的疫情信息
     * @param id
     * @return
     */
    CityEpidemicBean cityEpidemicByCityCode(String id);
}
