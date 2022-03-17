package org.miu.asd.creditcard.service;

import org.joda.time.LocalDate;
import org.miu.asd.creditcard.domain.CreditCardAccount;
import org.miu.asd.creditcard.domain.CreditCardType;
import org.miu.asd.creditcard.domain.calculator.strategy.BronzeCreditCard;
import org.miu.asd.creditcard.domain.calculator.strategy.CreditPaymentCalculator;
import org.miu.asd.creditcard.domain.calculator.strategy.GoldCreditCard;
import org.miu.asd.creditcard.domain.calculator.strategy.SilverCreditCard;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.framework.domain.AccountFactory;

public class CreditCardAccountFactory implements AccountFactory {
    private LocalDate expiredDate;
    private CreditCardType creditCardType;

    public CreditCardAccountFactory(LocalDate expiredDate, CreditCardType creditCardType) {
        this.expiredDate = expiredDate;
        this.creditCardType = creditCardType;
    }

    @Override
    public Account initAccount(String accountNumber, Customer customer) {
        CreditPaymentCalculator strategy;
        if(creditCardType.equals(CreditCardType.BRONZE))
            strategy = new BronzeCreditCard();
        else if(creditCardType.equals(CreditCardType.GOLD))
            strategy=new GoldCreditCard();
        else strategy=new SilverCreditCard();
        return new CreditCardAccount(accountNumber,customer,expiredDate,creditCardType,strategy);
    }
}
