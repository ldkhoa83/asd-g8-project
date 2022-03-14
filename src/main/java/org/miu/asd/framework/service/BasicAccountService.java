package org.miu.asd.framework.service;

import org.miu.asd.framework.dao.AccountDao;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEntry;
import org.miu.asd.framework.domain.AccountEvent;

import java.util.Observable;

public abstract class BasicAccountService extends Observable implements AccountService {
    private AccountDao accountDao;

    public BasicAccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account getAccount(String accountID) {
        return accountDao.getAccount(accountID);
    }

    @Override
    public void deposit(String accountID, Double amountOfMoney, AccountEvent accountEvent) {
        Account account = accountDao.getAccount(accountID);
        AccountEntry accountEntry = performDeposit(account,amountOfMoney,accountEvent);
        accountDao.updateAccount(account);
        notifyObservers(accountEntry);
    }

    @Override
    public void withdraw(String accountID, Double amountOfMoney, AccountEvent accountEvent) {
        Account account = accountDao.getAccount(accountID);
        AccountEntry accountEntry = performWithdraw(account,amountOfMoney,accountEvent);
        accountDao.updateAccount(account);
        notifyObservers(accountEntry);
    }

    protected abstract AccountEntry performWithdraw(Account account, Double amountOfMoney, AccountEvent accountEvent);

    protected abstract AccountEntry performDeposit(Account account, Double amountOfMoney, AccountEvent accountEvent);
}
