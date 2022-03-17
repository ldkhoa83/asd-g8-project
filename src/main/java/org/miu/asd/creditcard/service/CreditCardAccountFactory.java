package org.miu.asd.creditcard.service;

import org.joda.time.LocalDate;
import org.miu.asd.creditcard.domain.CreditCardAccount;
import org.miu.asd.creditcard.domain.CreditCardType;
import org.miu.asd.creditcard.domain.calculator.strategy.BronzePaymentCalculator;
import org.miu.asd.creditcard.domain.calculator.strategy.CreditPaymentStrategy;
import org.miu.asd.creditcard.domain.calculator.strategy.GoldPaymentCalculator;
import org.miu.asd.creditcard.domain.calculator.strategy.SilverPaymentCalculator;
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
        CreditPaymentStrategy strategy;
        if(creditCardType.equals(CreditCardType.BRONZE))
            strategy = new BronzePaymentCalculator();
        else if(creditCardType.equals(CreditCardType.GOLD))
            strategy=new GoldPaymentCalculator();
        else strategy=new SilverPaymentCalculator();
        return new CreditCardAccount(accountNumber,customer,expiredDate,creditCardType,strategy);
    }
}
