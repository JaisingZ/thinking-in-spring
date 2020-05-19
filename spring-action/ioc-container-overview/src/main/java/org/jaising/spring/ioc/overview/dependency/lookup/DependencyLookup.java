package org.jaising.spring.ioc.overview.dependency.lookup;

import org.jaising.spring.ioc.overview.dependency.annotation.Super;
import org.jaising.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Author: Jaising
 * @Description: 依赖查找示例
 *               1.通过Bean名称查找
 *               2.通过Bean类型查找
 *               3.通过Bean名称+类型查找
 *               4.通过Java注解查找
 * @Date: Created in 5/19/2020 8:45 PM
 */
public class DependencyLookup {

    public static void main(String[] args) {
        // 1.配置xml配置文件
        // 2.启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");

        lookupByAnnotation(beanFactory);

        lookupSingletonByType(beanFactory);
        lookupCollectionByType(beanFactory);

        lookupInLazyByName(beanFactory);
        lookupInRealTimeByName(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) ((ListableBeanFactory) beanFactory).getBeansWithAnnotation(Super.class);
            System.out.println("通过@Super注解查找所有user对象:" + users);
        }
    }

    /**
     * 通过Bean类型查找——单个实例
     */
    private static void lookupSingletonByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("通过类型查找:" + user);
    }

    /**
     * 通过Bean类型查找——集合实例
     */
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有user对象集合为:" + users);
        }
    }

    /**
     * 通过Bean名称查找——延时查找
     */
    private static void lookupInLazyByName(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟加载Bean:" + user);
    }

    /**
     * 通过Bean名称查找——实时查找
     */
    private static void lookupInRealTimeByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时加载Bean:" + user);
    }
}
