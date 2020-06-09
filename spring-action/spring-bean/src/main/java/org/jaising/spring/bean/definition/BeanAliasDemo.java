package org.jaising.spring.bean.definition;

import org.jaising.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Jaising
 * @Description: Bean 别名设置示例
 * @Date: Created in 6/9/2020 9:53 PM
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 xml 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INFO/bean-definition-context.xml");
        User user = beanFactory.getBean("user", User.class);
        User jaisingUser = beanFactory.getBean("jaising-user", User.class);
        System.out.println("jaising-user 是否与 user 相同:" + (jaisingUser == user));
    }

}
