package club.zby.wuhan.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: 赵博雅
 * @Date: 2020/5/25 13:25
 */
@Entity
@Table(name = "huanjing_info")
public class QiXiang implements Serializable {

    @Id
    private String id;
    private String nameeen;
    private String cityname;
    private String cuty;
    private String temp;
    private String tempf;
    private String WD;
    private String wde;
    private String WS;
    private String wse;
    private String SD1;
    private String time;
    private String weather;
    private String weathere;
    private String weathercode;
    private String qy;
    private String njd;
    private String sd;
    private String rain;
    private String rain24h;
    private String aqi;
    private String limitnumber;
    private String aqi_pm25;
    private String date;

    public QiXiang(String id, String nameeen, String cityname, String cuty, String temp, String tempf, String WD, String wde, String WS, String wse, String SD1, String time, String weather, String weathere, String weathercode, String qy, String njd, String sd, String rain, String rain24h, String aqi, String limitnumber, String aqi_pm25, String date) {
        this.id = id;
        this.nameeen = nameeen;
        this.cityname = cityname;
        this.cuty = cuty;
        this.temp = temp;
        this.tempf = tempf;
        this.WD = WD;
        this.wde = wde;
        this.WS = WS;
        this.wse = wse;
        this.SD1 = SD1;
        this.time = time;
        this.weather = weather;
        this.weathere = weathere;
        this.weathercode = weathercode;
        this.qy = qy;
        this.njd = njd;
        this.sd = sd;
        this.rain = rain;
        this.rain24h = rain24h;
        this.aqi = aqi;
        this.limitnumber = limitnumber;
        this.aqi_pm25 = aqi_pm25;
        this.date = date;
    }

    public QiXiang() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameeen() {
        return nameeen;
    }

    public void setNameeen(String nameeen) {
        this.nameeen = nameeen;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCuty() {
        return cuty;
    }

    public void setCuty(String cuty) {
        this.cuty = cuty;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTempf() {
        return tempf;
    }

    public void setTempf(String tempf) {
        this.tempf = tempf;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWde() {
        return wde;
    }

    public void setWde(String wde) {
        this.wde = wde;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getWse() {
        return wse;
    }

    public void setWse(String wse) {
        this.wse = wse;
    }

    public String getSD1() {
        return SD1;
    }

    public void setSD1(String SD1) {
        this.SD1 = SD1;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeathere() {
        return weathere;
    }

    public void setWeathere(String weathere) {
        this.weathere = weathere;
    }

    public String getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(String weathercode) {
        this.weathercode = weathercode;
    }

    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getRain24h() {
        return rain24h;
    }

    public void setRain24h(String rain24h) {
        this.rain24h = rain24h;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getLimitnumber() {
        return limitnumber;
    }

    public void setLimitnumber(String limitnumber) {
        this.limitnumber = limitnumber;
    }

    public String getAqi_pm25() {
        return aqi_pm25;
    }

    public void setAqi_pm25(String aqi_pm25) {
        this.aqi_pm25 = aqi_pm25;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "QiXiang{" +
                "nameeen='" + nameeen + '\'' +
                ", cityname='" + cityname + '\'' +
                ", cuty='" + cuty + '\'' +
                ", temp='" + temp + '\'' +
                ", tempf='" + tempf + '\'' +
                ", WD='" + WD + '\'' +
                ", wde='" + wde + '\'' +
                ", WS='" + WS + '\'' +
                ", wse='" + wse + '\'' +
                ", SD1='" + SD1 + '\'' +
                ", time='" + time + '\'' +
                ", weather='" + weather + '\'' +
                ", weathere='" + weathere + '\'' +
                ", weathercode='" + weathercode + '\'' +
                ", qy='" + qy + '\'' +
                ", njd='" + njd + '\'' +
                ", sd='" + sd + '\'' +
                ", rain='" + rain + '\'' +
                ", rain24h='" + rain24h + '\'' +
                ", aqi='" + aqi + '\'' +
                ", limitnumber='" + limitnumber + '\'' +
                ", aqi_pm25='" + aqi_pm25 + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
