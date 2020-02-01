package club.zby.wuhan.bean.EpidemicBean;

import java.util.List;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/1 18:32
 */
public class NationalEpidemicBean {

    private String title;
    private String map;
    private String trend_img;
    private String trend_incr_img;
    private String yst_sure_cnt;
    private String yst_cure_cnt;
    private String yst_like_cnt;
    private String yst_die_cnt;
    private List<ProvinceEpidemicBean> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getTrend_img() {
        return trend_img;
    }

    public void setTrend_img(String trend_img) {
        this.trend_img = trend_img;
    }

    public String getTrend_incr_img() {
        return trend_incr_img;
    }

    public void setTrend_incr_img(String trend_incr_img) {
        this.trend_incr_img = trend_incr_img;
    }

    public String getYst_sure_cnt() {
        return yst_sure_cnt;
    }

    public void setYst_sure_cnt(String yst_sure_cnt) {
        this.yst_sure_cnt = yst_sure_cnt;
    }

    public String getYst_cure_cnt() {
        return yst_cure_cnt;
    }

    public void setYst_cure_cnt(String yst_cure_cnt) {
        this.yst_cure_cnt = yst_cure_cnt;
    }

    public String getYst_like_cnt() {
        return yst_like_cnt;
    }

    public void setYst_like_cnt(String yst_like_cnt) {
        this.yst_like_cnt = yst_like_cnt;
    }

    public String getYst_die_cnt() {
        return yst_die_cnt;
    }

    public void setYst_die_cnt(String yst_die_cnt) {
        this.yst_die_cnt = yst_die_cnt;
    }

    public List<ProvinceEpidemicBean> getList() {
        return list;
    }

    public void setList(List<ProvinceEpidemicBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "NationalEpidemicBean{" +
                "title='" + title + '\'' +
                ", map='" + map + '\'' +
                ", trend_img='" + trend_img + '\'' +
                ", trend_incr_img='" + trend_incr_img + '\'' +
                ", yst_sure_cnt='" + yst_sure_cnt + '\'' +
                ", yst_cure_cnt='" + yst_cure_cnt + '\'' +
                ", yst_like_cnt='" + yst_like_cnt + '\'' +
                ", yst_die_cnt='" + yst_die_cnt + '\'' +
                ", list=" + list +
                '}';
    }
}
