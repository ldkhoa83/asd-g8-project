package org.miu.asd.creditcard.service;

import org.joda.time.LocalDate;
import org.miu.asd.creditcard.domain.CreditCardAccount;
import org.miu.asd.creditcard.domain.CreditCardType;
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
    public Account initAccount(String accountID, Customer customer) {
        return new CreditCardAccount(accountID,customer,expiredDate,creditCardType);
    }
}
