package club.zby.wuhan.HttpRequestMethod.HttpInterface;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/31 18:39
 */
public interface HttpMethod {

    /**
     * 获取城市信息(数据类型1)
     * @return
     */
    String getHealingCity1();

    /**
     * 获取城市信息(数据类型2，分布显示)
     * @return
     */
    String getHealingCity2();

    /**
     * 获取全国感染情况
     * @return
     */
    String getHealingPos();


}
