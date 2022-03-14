package org.miu.asd.banking.domain;

import org.joda.time.LocalDate;
import org.miu.asd.framework.domain.Party;

public class Person extends Party {
    private LocalDate birthday;

    public Person(String name, String street, String city, String state, String zipCode, LocalDate birthday) {
        super(name, street, city, state, zipCode);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
