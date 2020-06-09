package org.jaising.spring.bean.definition;

import org.jaising.spring.ioc.overview.dependency.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @Author: Jaising
 * @Description: {@link org.springframework.beans.factory.config.BeanDefinition} 示例
 * @Date: Created in 6/9/2020 8:58 PM
 */
public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置 Bean 的属性
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "Jaising");
        // 获取 BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // beanDefinition 并非 bean 终态，可以自定义修改

        // 2.通过 AbstractBeanDefinition 及其衍生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues
                .add("id", 1)
                .add("name", "Jaising");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
    }
}
