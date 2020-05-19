package org.jaising.test.spring;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @Author: Jaising
 * @Description: 演示Spring 3.0之前通过Java Beans实现IOC容器完成元信息编程的过程；
 *               Java Beans完成了Bean内部描述、时间、内容编辑，
 *               并由BeanContext统一Bean实例的托管
 * @Date: Created in 5/17/2020 10:02 AM
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        // stopClass在那个类层次停止自省
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    // PropertyDescriptor 允许添加属性编辑器 - PropertyEditor
                    // 不直接调用bean的readMethod / writeMethod，交给PropertyEditorSupport完成
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String propertyName = propertyDescriptor.getName();
                    // 为age添加PropertyEditor属性
                    if ("age".equals(propertyName)) {
                        propertyDescriptor.setPropertyEditorClass(StringToInteger.class);
                    }
                });
    }

    static class StringToInteger extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
