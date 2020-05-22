package org.jaising.spring.ioc.overview.dependency.container;

import org.jaising.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @Author: Jaising
 * @Description: {@link org.springframework.context.ApplicationContext} 作为IoC容器
 * @Date: Created in 5/22/2020 9:48 PM
 */
public class AnnotationAsIoCContainer {

    public static void main(String[] args) {
        // 加载 ApplicationContext 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationAsIoCContainer.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * 通过Java注解的方式定义了一个Bean
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(987323161L);
        user.setName("Boy");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有user对象集合为:" + users);
        }
    }
}
