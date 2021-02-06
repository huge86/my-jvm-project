package cn.huzunjie.spring5.demo.aop;

/**
 * @Author HuZunJie
 * @Date 2021/2/5 19:07
 * @Email 826992656@qq.com
 * @Version 1.0
 */

/*
* 以下面的User类举例：
* 1、连接点：类中需要被增强的方法，都是连接点
* 2、切入点：实际真正被增强的方法，成为切入点
* 3、通知（增强):实际增强的业务逻辑部分，称为通知（增强）；通知的类型：前置、后置、环绕、异常、最终
* 4、切面：是动作，把通知应用到切入点的过程，就叫做切面
*
* Spring框架一般基于AspectJ实现AOP操作，AspectJ不是spring组成部分，独立AOP框架，可以单独使用
* 基于AspectJ实现AOP操作的两种方式：1）基于xml配置文件（切入点表达式）；2）基于注解方式（常用）
*
* 切入点表达式：
* 作用：知道对那个类里面的那个方法进行增强；
* 语法结构：execution([权限修饰符][返回类型][类全路径][方法名称][参数列表])
* 举例1：对cn.huzunjie.spring5.dao.UserDao类里面的update方法进行增强
*       execution(* cn.huzunjie.spring5.dao.UserDao.update(..))
*       权限修饰符可以用*代替，后面有个空格，返回类型可以忽略，方法小括号里面的两个点，代表参数列表
*
* 举例2：对cn.huzunjie.spring5.dao.UserDao类里面的所有方法进行增强
 *       execution(* cn.huzunjie.spring5.dao.UserDao.*(..))
 *       权限修饰符可以用*代替，后面有个空格，返回类型可以忽略，方法名用*代替，方法小括号里面的两个点，代表参数列表
 *
 * 举例3：对cn.huzunjie.spring5.dao包里面的所有类，类里面的所有方法进行增强
 *       execution(* cn.huzunjie.spring5.dao.*.*(..))
 *       权限修饰符可以用*代替，后面有个空格，返回类型可以忽略，包后面的类名用*代替，方法名用*代替，方法小括号里面的两个点，代表参数列表
* */
public class AopTerminology {

}

class User {
    void add(){

    };
    void delete(){

    };
    void update(){

    };
    void query(){

    };
}
