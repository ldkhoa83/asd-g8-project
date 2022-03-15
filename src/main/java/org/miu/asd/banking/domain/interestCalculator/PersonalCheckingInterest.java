package org.miu.asd.banking.domain.interestCalculator;

import org.miu.asd.framework.domain.InterestComputationStrategy;

public class PersonalCheckingInterest implements InterestComputationStrategy {

    @Override
    public Double computeInterest(Double balance) {
        return balance * 0.03;
    }
}
