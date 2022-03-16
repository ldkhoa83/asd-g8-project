package org.miu.asd.creditcard.service;

import org.miu.asd.framework.dao.AccountDAO;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEntry;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.service.BasicAccountService;

public class CreditCardAccountService extends BasicAccountService {

    public CreditCardAccountService(AccountDAO accountDao) {
        super(accountDao);
    }

    @Override
    protected AccountEntry performWithdrawOnAccount(Account account, Double amountOfMoney, AccountEvent accountEvent) {
        return account.deposit(amountOfMoney,accountEvent);
    }

    @Override
    protected AccountEntry performDepositOnAccount(Account account, Double amountOfMoney, AccountEvent accountEvent) {
        return account.withdraw(amountOfMoney,accountEvent);
    }

    @Override
    public void addInterestForAllAccounts() {

    }
}
