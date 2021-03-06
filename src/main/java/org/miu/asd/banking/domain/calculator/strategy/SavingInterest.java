package org.miu.asd.banking.domain.calculator.strategy;

public class SavingInterest implements InterestComputationStrategy {

    @Override
    public Double computeInterest(Double balance) {
        if(balance<1000) return balance*0.01;
        if(balance>1000 && balance<5000) return balance*0.02;
        return balance * 0.04;
    }
}
