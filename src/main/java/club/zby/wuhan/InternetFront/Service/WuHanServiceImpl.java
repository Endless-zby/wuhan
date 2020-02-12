package club.zby.wuhan.InternetFront.Service;

import club.zby.wuhan.InternetFront.Dao.wuHanDao;
import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 15:27
 */
@Service
public class WuHanServiceImpl implements WuHanService {

    @Autowired
    private wuHanDao wuhandao;


    @Transactional
    @Override
    public List<CityEpidemicBean> cityEpidemic() {
        return wuhandao.findAll();
    }

    @Transactional
    @Override
    public CityEpidemicBean cityEpidemicByCityCode(String id) {
        return wuhandao.findAllById(id);
    }

    @Override
    public Map sumNumber() {
        return wuhandao.sumNumber();
    }
}
