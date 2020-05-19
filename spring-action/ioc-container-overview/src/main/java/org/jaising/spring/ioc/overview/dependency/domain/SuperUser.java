package org.jaising.spring.ioc.overview.dependency.domain;

import org.jaising.spring.ioc.overview.dependency.annotation.Super;

/**
 * @Author: Jaising
 * @Description: 超级用户
 * @Date: Created in 5/19/2020 9:41 PM
 */
@Super
public class SuperUser extends User {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
