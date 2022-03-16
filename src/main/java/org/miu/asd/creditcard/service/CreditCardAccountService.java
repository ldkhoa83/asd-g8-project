package org.miu.asd.creditcard.service;

import org.miu.asd.framework.dao.AccountDAO;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEntry;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.service.BasicAccountService;

import java.util.Collection;

public class CreditCardAccountService extends BasicAccountService {

    public CreditCardAccountService(AccountDAO accountDao) {
        super(accountDao);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return null;
    }

    @Override
    protected AccountEntry performWithdraw(Account account, Double amountOfMoney, AccountEvent accountEvent) {
        return null;
    }

    @Override
    protected AccountEntry performDeposit(Account account, Double amountOfMoney, AccountEvent accountEvent) {
        return null;
    }

    @Override
    protected AccountEntry performInterest(Account account) {
        return account.addInterest();
    }
}
