package org.jaising.test.spring;

/**
 * @Author: Jaising
 * @Description: Setter / Getter
 * Writable / Readable
 * @Date: Created in 5/17/2020 10:01 AM
 */
public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public static Person create(String name, Integer age) {
        return new Person(name, age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
