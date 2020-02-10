package club.zby.wuhan.bean.EpidemicBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/1 18:35
 */
@Entity
@Table(name = "tb_epidemic")
public class CityEpidemicBean implements Serializable {

    @Id
    private String id;
    private String country;
    private String province;
    private String province_code;
    private String city;
    private String sure_cnt;
    private String like_cnt;
    private String die_cnt;
    private String cure_cnt;

    public String getId() {
        return id;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSure_cnt() {
        return sure_cnt;
    }

    public void setSure_cnt(String sure_cnt) {
        this.sure_cnt = sure_cnt;
    }

    public String getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(String like_cnt) {
        this.like_cnt = like_cnt;
    }

    public String getDie_cnt() {
        return die_cnt;
    }

    public void setDie_cnt(String die_cnt) {
        this.die_cnt = die_cnt;
    }

    public String getCure_cnt() {
        return cure_cnt;
    }

    public void setCure_cnt(String cure_cnt) {
        this.cure_cnt = cure_cnt;
    }

    @Override
    public String toString() {
        return "CityEpidemicBean{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", province_code='" + province_code + '\'' +
                ", city='" + city + '\'' +
                ", sure_cnt='" + sure_cnt + '\'' +
                ", like_cnt='" + like_cnt + '\'' +
                ", die_cnt='" + die_cnt + '\'' +
                ", cure_cnt='" + cure_cnt + '\'' +
                '}';
    }
}
