package cn.huzunjie.flume.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author HuZunJie
 * @Date 2021/2/22 9:19
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class TimeStampInterceptor implements Interceptor{
    private ArrayList<Event> events = new ArrayList<>();
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {

//        从body里面取出ts时间,放入header中的timestap的key中
        Map<String, String> headers = event.getHeaders();
//        1 获取body中的ts数据
        String log = new String(event.getBody(), StandardCharsets.UTF_8);

        JSONObject jsonObject = JSONObject.parseObject(log);

        String ts = jsonObject.getString("ts");
//        2 将ts时间添加到header的timestap的key中
        headers.put("timestamp", ts);

        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {

        events.clear();
        for (Event event : list) {
            events.add(intercept(event));
        }

        return events;
    }

    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new TimeStampInterceptor();
        }
        @Override
        public void configure(Context context) {

        }

    }

    @Override
    public void close() {

    }
}
