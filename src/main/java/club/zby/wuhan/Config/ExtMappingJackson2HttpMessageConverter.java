package club.zby.wuhan.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 赵博雅
 * @Date: 2020/1/31 17:47
 */
@Configuration
public class ExtMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    /*解决no suitable HttpMessageConverter found for response type [class com.XXX] and content type [text/plain]*/
    public ExtMappingJackson2HttpMessageConverter(){
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.TEXT_HTML);
        setSupportedMediaTypes(mediaTypes);// tag6
    }
}

