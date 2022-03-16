package org.miu.asd.banking.domain.interestCalculator;

public class CheckingInterest implements InterestComputationStrategy {
    

    @Override
    public Double computeInterest(Double balance) {
        return balance<1000 ? balance * 0.015: balance * 0.025;
    }
}
