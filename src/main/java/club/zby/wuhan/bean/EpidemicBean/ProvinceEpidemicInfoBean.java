package club.zby.wuhan.bean.EpidemicBean;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/1 18:40
 */
public class ProvinceEpidemicInfoBean {

    private String sure_cnt;
    private String cure_cnt;
    private String die_cnt;
    private String like_cnt;

    public String getSure_cnt() {
        return sure_cnt;
    }

    public void setSure_cnt(String sure_cnt) {
        this.sure_cnt = sure_cnt;
    }

    public String getCure_cnt() {
        return cure_cnt;
    }

    public void setCure_cnt(String cure_cnt) {
        this.cure_cnt = cure_cnt;
    }

    public String getDie_cnt() {
        return die_cnt;
    }

    public void setDie_cnt(String die_cnt) {
        this.die_cnt = die_cnt;
    }

    public String getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(String like_cnt) {
        this.like_cnt = like_cnt;
    }

    @Override
    public String toString() {
        return "ProvinceEpidemicInfoBean{" +
                "sure_cnt='" + sure_cnt + '\'' +
                ", cure_cnt='" + cure_cnt + '\'' +
                ", die_cnt='" + die_cnt + '\'' +
                ", like_cnt='" + like_cnt + '\'' +
                '}';
    }
}
