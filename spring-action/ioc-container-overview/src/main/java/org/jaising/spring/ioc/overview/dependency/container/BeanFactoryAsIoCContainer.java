package org.jaising.spring.ioc.overview.dependency.container;

import org.jaising.spring.ioc.overview.dependency.annotation.Super;
import org.jaising.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Author: Jaising
 * @Description: {@link BeanFactory} 作为IoC容器
 * @Date: Created in 5/22/2020 9:16 PM
 */
public class BeanFactoryAsIoCContainer {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        // xml 配置路径
        String location = "META-INF/dependency-injection-context.xml";
        // 加载配置
        int beanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量" + beanDefinitionCount);
        // 依赖查找集合对象
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("通过@Super注解查找所有user对象:" + users);
        }
    }
}
