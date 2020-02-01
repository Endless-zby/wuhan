package club.zby.wuhan.bean.EpidemicBean;

import java.util.List;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/1 18:34
 */
public class ProvinceEpidemicBean {

    private String province;

    private ProvinceEpidemicInfoBean info;

    private List<CityEpidemicBean> list;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public ProvinceEpidemicInfoBean getInfo() {
        return info;
    }

    public void setInfo(ProvinceEpidemicInfoBean info) {
        this.info = info;
    }

    public List<CityEpidemicBean> getList() {
        return list;
    }

    public void setList(List<CityEpidemicBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ProvinceEpidemicBean{" +
                "province='" + province + '\'' +
                ", info=" + info +
                ", list=" + list +
                '}';
    }
}
