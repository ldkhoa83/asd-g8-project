package org.miu.asd.banking.domain;

import org.joda.time.Interval;
import org.miu.asd.banking.domain.interestCalculator.CompanyCheckingInterest;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;

public class CheckAccount extends Account {

    public CheckAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public String generateReport(Interval interval) {
        return null;
    }
}
