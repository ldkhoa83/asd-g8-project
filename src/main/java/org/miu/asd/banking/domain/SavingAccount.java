package org.miu.asd.banking.domain;

import org.joda.time.Interval;
import org.miu.asd.banking.domain.interestCalculator.CheckingInterest;
import org.miu.asd.banking.domain.interestCalculator.SavingInterest;
import org.miu.asd.banking.ui.AccountType;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.banking.domain.interestCalculator.InterestComputationStrategy;

public class SavingAccount extends Account {

    public SavingAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
        super.setInterestStrategy(new SavingInterest());
    }

    @Override
    public String generateReport(Interval interval) {
        return null;
    }
}
