package cn.huzunjie.flume.interceptor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
/**
 * @Author HuZunJie
 * @Date 2021/2/22 9:15
 * @Email 826992656@qq.com
 * @Version 1.0
 */

public class JSONUtils {
    public static void main(String[] args) {
        System.out.println(isJSONValidate("{1222}"));
        System.out.println(isJSONValidate("{\"age\":18}"));
    }
//    验证数据是否是json
    public static boolean isJSONValidate(String log){
        try {
            JSON.parse(log);
            return true;
        }catch (JSONException e){
            return false;
        }
    }


}
