package club.zby.wuhan.HttpRequestMethod.HttpInterface;

import club.zby.wuhan.Config.HttpRequest;
import club.zby.wuhan.Config.HttpRequestImpl;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/31 18:43
 */
public class HttpMethodImpl implements HttpMethod {

    @Autowired
    private HttpRequestImpl httpRequest;


    @Override
    public String getHealingCity1() {
        if (httpRequest == null) {
            this.HttpMethodImplInit();
        }
        return httpRequest.sendGet("https://api.m.sm.cn/rest", "format=json&method=Huoshenshan.healingCity&mapType=1");
    }

    @Override
    public String getHealingCity2() {
        if (httpRequest == null) {
            this.HttpMethodImplInit();
        }
        return httpRequest.sendGet("https://api.m.sm.cn/rest", "format=json&method=Huoshenshan.healingCity&mapType=2");
    }

    @Override
    public String getHealingPos() {
        if (httpRequest == null) {
            this.HttpMethodImplInit();
        }
        return httpRequest.sendGet("https://api.m.sm.cn/rest", "format=json&method=Huoshenshan.healingPos&uc_param_str=gi");

    }

    public void HttpMethodImplInit() {
        HttpRequestImpl httpRequest = new HttpRequestImpl();
        this.httpRequest = httpRequest;
    }

}
