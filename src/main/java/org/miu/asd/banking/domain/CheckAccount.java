package org.miu.asd.banking.domain;

import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import org.miu.asd.banking.domain.interestCalculator.CheckingInterest;
import org.miu.asd.banking.domain.interestCalculator.InterestComputationStrategy;
import org.miu.asd.banking.ui.AccountType;
import org.miu.asd.framework.domain.*;

public class CheckAccount extends Account {
    private InterestComputationStrategy interestComputationStrategy;

    public CheckAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer, AccountType.CHECKING);
    }

    @Override
    public String generateReport(Interval interval) {
        return null;
    }
}
