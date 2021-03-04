package cn.huzunjie.jvm.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: HuZunJie
 * Date: 2021/3/4 10:27
 * Email: 826992656@qq.com
 * Version: 0.0.1
 * Desc:
 */


@RestController
@Slf4j
public class LoggerController {
    @Autowired
    KafkaTemplate kafkaTemplate;
    @RequestMapping("/applog")
    public String applog(@RequestBody String mockLog){

        log.info(mockLog);

        JSONObject jsonObject = JSON.parseObject(mockLog);
        JSONObject startJson = jsonObject.getJSONObject("start");
        if(startJson != null){

            kafkaTemplate.send("gmall_start",mockLog);
        }else{

            kafkaTemplate.send("gmall_event",mockLog);
        }

        return "success";

    }
}

