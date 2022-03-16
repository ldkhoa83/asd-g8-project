package org.miu.asd.framework.service;

import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.miu.asd.framework.dao.AccountDAO;
import org.miu.asd.framework.domain.*;

import java.util.Collection;
import java.util.List;

public abstract class BasicAccountService implements Observable, AccountService {

    private AccountDAO accountDAO;
    protected AccountEventType accountEventType;


    public BasicAccountService(AccountDAO accountDao) {
        this.accountDAO = accountDao;
    }

    @Override
    public Account createAccount(String accountID, Customer customer, AccountFactory accountFactory) {
        Account account = accountFactory.initAccount(accountID, customer);
        getAccountDAO().saveAccount(account);
        return account;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountDAO.loadAllAccounts();
    }

    @Override
    public Account getAccount(String accountID) {
        return accountDAO.loadAccount(accountID);
    }

    @Override
    public void deposit(String accountID, Double amountOfMoney, AccountEvent accountEvent) {
        Account account = accountDAO.loadAccount(accountID);
        AccountEntry accountEntry = performDepositOnAccount(account, amountOfMoney, accountEvent);
        accountDAO.updateAccount(account);
        notifyObservers(accountEntry,account);

    }

    @Override
    public void withdraw(String accountID, Double amountOfMoney, AccountEvent accountEvent) {
        Account account = accountDAO.loadAccount(accountID);
        AccountEntry accountEntry = performWithdrawOnAccount(account, amountOfMoney, accountEvent);
        accountDAO.updateAccount(account);
        notifyObservers(accountEntry,account);

    }

    protected AccountDAO getAccountDAO() {
        return accountDAO;
    }

    @Override
    public String generateMonthlyBillReport(String accountID) {
        Account account = accountDAO.loadAccount(accountID);
        Interval lastMonth = new Interval(Period.months(1), Instant.now());

        return account.generateReport(lastMonth);
    }

    public AccountEventType getAccountEventType() {
        return accountEventType;
    }


    protected abstract  void  performNotify(AccountEntry accountEntry, Account account);

    protected abstract AccountEntry performWithdrawOnAccount(Account account, Double amountOfMoney, AccountEvent accountEvent);

    protected abstract AccountEntry performDepositOnAccount(Account account, Double amountOfMoney, AccountEvent accountEvent);
}
