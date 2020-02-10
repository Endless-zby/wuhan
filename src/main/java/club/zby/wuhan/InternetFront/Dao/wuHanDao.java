package club.zby.wuhan.InternetFront.Dao;

import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 15:27
 */
public interface wuHanDao extends JpaRepository<CityEpidemicBean,String>, JpaSpecificationExecutor<CityEpidemicBean> {

    CityEpidemicBean findAllById(String id);
}
