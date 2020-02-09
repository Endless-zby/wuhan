package club.zby.wuhan;

import club.zby.wuhan.HttpRequestMethod.HttpMethod.HttpMethodImpl;
import club.zby.wuhan.bean.EpidemicBean.CityEpidemicBean;
import club.zby.wuhan.bean.EpidemicBean.NationalEpidemicBean;
import club.zby.wuhan.bean.EpidemicBean.ProvinceEpidemicBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 0:23
 */
public class xxxx {
    public static void main(String[] args) {
        HttpMethodImpl httpMethod = new HttpMethodImpl();
        String healingPos = httpMethod.getHealingCity1();
        NationalEpidemicBean nationalEpidemicBean = JSON.parseObject(healingPos, NationalEpidemicBean.class);
        List<ProvinceEpidemicBean> list = nationalEpidemicBean.getList();
        ArrayList<CityEpidemicBean> cityEpidemicBeans = new ArrayList<>();

        for (ProvinceEpidemicBean provinceEpidemicBean: list) {
            cityEpidemicBeans.addAll(provinceEpidemicBean.getList());
        }


        List<CityEpidemicBean> collect = Stream.of(cityEpidemicBeans.get(1), cityEpidemicBeans.get(2), cityEpidemicBeans.get(3))
                .filter(cityEpidemicBean -> Integer.valueOf(cityEpidemicBean.getCure_cnt()) > 2)
                .collect(Collectors.toList());


        System.out.println(collect.toString());


    }
}
