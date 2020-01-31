package club.zby.wuhan.Config;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/31 18:44
 */
public interface HttpRequest {


    String sendGet(String url, String param);


    String sendPost(String url, String param);
}
