package club.zby.wuhan.HttpRequestMethod.HttpMethodService;

import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/1 20:27
 */
@Service
public interface HttpMethodDao extends JpaRepository<CityEpidemicBean,String>, JpaSpecificationExecutor<CityEpidemicBean> {


}
