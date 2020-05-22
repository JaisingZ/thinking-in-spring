package org.jaising.spring.ioc.overview.dependency.injection;

import org.jaising.spring.ioc.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Author: Jaising
 * @Description: 依赖注入
 * @Date: Created in 5/21/2020 9:19 PM
 */
public class DependencyInjection {

    public static void main(String[] args) {
        // 1.配置xml配置文件
        // 2.启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        // 依赖来源一：自建Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        // 依赖来源二：依赖注入（内建依赖，非Bean）——无法通过依赖查找获取
        System.out.println(userRepository.getBeanFactory());

        // 依赖来源三：依赖注入（容器内建Bean），Spring容器初始化的Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(environment);

        ObjectFactory objectFactory = userRepository.getObjectFactory();

        System.out.println(objectFactory.getObject() == beanFactory);

        // 依赖查找（错误）——发现依赖注入和依赖查找不同源
//        System.out.println(beanFactory.getBean(BeanFactory.class));
    }
}
