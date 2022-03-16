package org.miu.asd.creditcard.domain.interestandpaymentcalculator;

public class GoldCreditCard implements CreditPaymentCalculator {
    @Override
    public Double computeInterest(Double balance) {
        return balance*0.06;
    }
    @Override
    public double calculateTotalDue(Double balance) {
        return balance * 0.1;
    }
}
