package org.miu.asd.banking.domain.interestCalculator;

import org.miu.asd.framework.domain.InterestComputationStrategy;


public class PersonalSavingInterest implements InterestComputationStrategy {

    @Override
    public Double computeInterest(Double balance) {
        return balance * 0.06;
    }
}
