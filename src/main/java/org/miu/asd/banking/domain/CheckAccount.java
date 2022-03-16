package org.miu.asd.banking.domain;

import org.joda.time.Interval;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;

public class CheckAccount extends Account {

    public CheckAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public BankingReport generateReport(Interval interval) {
        return null;
    }
}
