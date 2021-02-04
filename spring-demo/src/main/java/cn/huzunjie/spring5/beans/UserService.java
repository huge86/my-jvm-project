package cn.huzunjie.spring5.beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * @Author HuZunJie
 * @Date 2021/2/4 14:44
 * @Email 826992656@qq.com
 * @Version 1.0
 */

//在注解里面value属性值可以省略不写，默认值是类名称，首字母小写
//@Component(value="userService") //等价于<bean id="userService" class=“...”/>
@Service
public class UserService {
    public void add(){
        System.out.println("service add ......");
    }
}
