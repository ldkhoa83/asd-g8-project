package org.miu.asd.creditcard.domain.interestandpaymentcalculator;

public class SilverCreditCard implements CreditPaymentCalculator {
    @Override
    public Double computeInterest(Double balance) {
        return balance*0.08;
    }
    @Override
    public double calculateTotalDue(Double balance) {
        return balance * 0.12;
    }
}
