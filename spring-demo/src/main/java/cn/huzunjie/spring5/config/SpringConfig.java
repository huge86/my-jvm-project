package cn.huzunjie.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author HuZunJie
 * @Date 2021/2/4 16:00
 * @Email 826992656@qq.com
 * @Version 1.0
 */

@Configuration//作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"cn.huzunjie.spring5.config", "cn.huzunjie.spring5.pojo"})//配置组件扫描的包路径，数组形式
public class SpringConfig {
}
