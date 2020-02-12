package club.zby.wuhan.InternetFront.Dao;

import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 15:27
 */
public interface wuHanDao extends JpaRepository<CityEpidemicBean,String>, JpaSpecificationExecutor<CityEpidemicBean> {

    CityEpidemicBean findAllById(String id);

    @Query(nativeQuery = true,value = "SELECT sum(sure_cnt) as sure, sum(cure_cnt) as cure, sum(die_cnt) as die FROM tb_epidemic")
    Map sumNumber();
}
