package org.miu.asd.banking.domain.interestcalculator;

import org.miu.asd.framework.domain.InterestComputationStrategy;

public class CompanyCheckingInterest implements InterestComputationStrategy {
    @Override
    public Double computeInterest(Double balance) {
        return balance<1000 ? balance * 0.015: balance * 0.025;
    }
}
