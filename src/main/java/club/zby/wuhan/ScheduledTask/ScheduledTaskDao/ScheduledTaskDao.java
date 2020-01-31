package club.zby.wuhan.ScheduledTask.ScheduledTaskDao;


import club.zby.wuhan.bean.ScheduledTaskBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduledTaskDao extends JpaRepository<ScheduledTaskBean,String>, JpaSpecificationExecutor<ScheduledTaskBean> {

    /**
     * 根据key 获取 任务信息
     */
    @Modifying
    @Query(nativeQuery = true,value = "select * from tb_task where task_key = ?")
    ScheduledTaskBean getByKey(String key);

    /**
     * 获取程序初始化需要自启的任务信息
     */
    @Modifying
    @Query(nativeQuery = true,value = "select * from tb_task where init_start_flag='1'")
    List<ScheduledTaskBean> getAllNeedStartTask();

    /**
     * 获取所有任务
     */
    @Modifying
    @Query(nativeQuery = true,value = "select * from tb_task")
    List<ScheduledTaskBean> getAllTask();

}
