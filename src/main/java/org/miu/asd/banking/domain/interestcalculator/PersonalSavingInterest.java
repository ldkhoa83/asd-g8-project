package org.miu.asd.banking.domain.interestcalculator;

import org.miu.asd.framework.domain.InterestComputationStrategy;


public class PersonalSavingInterest implements InterestComputationStrategy {

    @Override
    public Double computeInterest(Double balance) {
        if(balance<1000) return balance*0.01;
        if(balance>1000 && balance<5000) return balance*0.02;
        return balance * 0.04;
    }
}
