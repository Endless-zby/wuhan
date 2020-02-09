package club.zby.wuhan.HttpRequestMethod.HttpMethodService;

import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/1 20:27
 */
@Transactional
public interface HttpMethodDao extends JpaRepository<CityEpidemicBean,String>, JpaSpecificationExecutor<CityEpidemicBean> {

    @Modifying
    @Query(nativeQuery = true,value = "update tb_epidemic f set f.sure_cnt = ?2,f.like_cnt = ?3,f.die_cnt = ?4,f.cure_cnt = ?5 where f.id = ?1")
    int upDataCityEpidemic(String id,String sure_cnt,String like_cnt, String die_cnt,String cure_cnt);

}
