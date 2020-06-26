package club.zby.wuhan.HttpRequestMethod.HttpMethodService;

import club.zby.wuhan.bean.QiXiang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;

/**
 * @Author: 赵博雅
 * @Date: 2020/5/25 13:37
 */
@Transactional
public interface QiXiangDao extends JpaRepository<QiXiang,String>, JpaSpecificationExecutor<QiXiang> {

}

