package org.miu.asd.banking.domain;

import org.joda.time.LocalDate;
import org.miu.asd.framework.domain.Customer;

public class Person extends Customer {
    private String birthday;

    public Person(String name, String street, String city, String state, String zipCode, String birthday) {
        super(name, street, city, state, zipCode);
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
