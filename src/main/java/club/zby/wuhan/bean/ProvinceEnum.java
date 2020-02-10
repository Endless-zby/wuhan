package club.zby.wuhan.bean;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 17:12
 */
public enum ProvinceEnum {

    上海市("上海市","2000"),
    中国台湾("中国台湾","2001"),
    中国澳门("中国澳门","2002"),
    中国香港("中国香港","2003"),
    云南省("云南省","2004"),
    内蒙古自治区("内蒙古自治区","2005"),
    北京市("北京市","2006"),
    吉林省("吉林省","2007"),
    四川省("四川省","2008"),
    天津市("天津市","2009"),
    宁夏回族自治区("宁夏回族自治区","2010"),
    安徽省("安徽省","2011"),
    山东省("山东省","2012"),
    山西省("山西省","2013"),
    广东省("广东省","2014"),
    广西壮族自治区("广西壮族自治区","2015"),
    待确认地区("待确认地区","2016"),
    新疆维吾尔自治区("新疆维吾尔自治区","2017"),
    江苏省("江苏省","2018"),
    江西省("江西省","2019"),
    河北省("河北省","2020"),
    河南省("河南省","2021"),
    浙江省("浙江省","2022"),
    海南省("海南省","2023"),
    湖北省("湖北省","2024"),
    湖南省("湖南省","2025"),
    甘肃省("甘肃省","2026"),
    福建省("福建省","2027"),
    西藏自治区("西藏自治区","2028"),
    贵州省("贵州省","2029"),
    辽宁省("辽宁省","2030"),
    重庆市("重庆市","2031"),
    陕西省("陕西省","2032"),
    青海省("青海省","2033"),
    黑龙江省("黑龙江省","2034");


    private String provinceName;
    private String provinceCode;

    ProvinceEnum(String provinceName,String provinceCode){
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
