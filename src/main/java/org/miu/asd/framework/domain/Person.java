package org.miu.asd.framework.domain;

import org.joda.time.LocalDate;
import org.miu.asd.framework.domain.Customer;

public class Person extends Customer {
    private LocalDate birthday;

    public Person(String name, String street, String city, String state, String zipCode, LocalDate birthday) {
        super(name, street, city, state, zipCode);
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
