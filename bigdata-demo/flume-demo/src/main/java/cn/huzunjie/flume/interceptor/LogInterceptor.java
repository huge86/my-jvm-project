package cn.huzunjie.flume.interceptor;
import com.alibaba.fastjson.JSON;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
/**
 * @Author HuZunJie
 * @Date 2021/2/22 9:19
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class LogInterceptor implements Interceptor{
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {

        //取数据后进行校验
//        1 获取数据
        byte[] body = event.getBody();
        String log = new String(body, StandardCharsets.UTF_8);
//        2 校验
        if (JSONUtils.isJSONValidate(log)) {
            return event;
        } else {
            return null;
        }
    }

    @Override
    public List<Event> intercept(List<Event> list) {

        Iterator<Event> iterator = list.iterator();

        while (iterator.hasNext()){
            Event next = iterator.next();
            if(intercept(next)==null){
                iterator.remove();
            }
        }

        return list;
    }

    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new LogInterceptor();
        }
        @Override
        public void configure(Context context) {

        }

    }

    @Override
    public void close() {

    }
}
