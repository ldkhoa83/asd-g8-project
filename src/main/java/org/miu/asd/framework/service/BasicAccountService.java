package org.miu.asd.framework.service;

import org.miu.asd.framework.dao.AccountDAO;
import org.miu.asd.framework.domain.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Observable;
import java.util.stream.Collectors;

public abstract class BasicAccountService extends Observable implements AccountService {
    private AccountDAO accountDAO;

    public BasicAccountService(AccountDAO accountDao) {
        this.accountDAO = accountDao;
    }

    @Override
    public Account createAccount(String accountID, Customer customer, AccountFactory accountFactory) {
        Account account = accountFactory.initAccount(accountID,customer);
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
        AccountEntry accountEntry = performDeposit(account,amountOfMoney,accountEvent);
        accountDAO.updateAccount(account);
        notifyObservers(accountEntry);
    }

    @Override
    public void withdraw(String accountID, Double amountOfMoney, AccountEvent accountEvent) {
        Account account = accountDAO.loadAccount(accountID);
        AccountEntry accountEntry = performWithdraw(account,amountOfMoney,accountEvent);
        accountDAO.updateAccount(account);
        notifyObservers(accountEntry);
    }

    @Override
    public void addInterest() {
        Account account;
        Collection<String> accountNumbers=getAllAccounts().stream()
                .map(Account::getAccountNumber).collect(Collectors.toList());
        for(String acct:accountNumbers){
            account=accountDAO.loadAccount(acct);
            account.addInterest();
            AccountEntry accountEntry = performInterest(account);
            accountDAO.updateAccount(account);
            //notifyObservers(accountEntry);
        }

    }



    protected AccountDAO getAccountDAO(){
        return accountDAO;
    }

    protected abstract AccountEntry performWithdraw(Account account, Double amountOfMoney, AccountEvent accountEvent);

    protected abstract AccountEntry performDeposit(Account account, Double amountOfMoney, AccountEvent accountEvent);

    protected abstract AccountEntry performInterest(Account account);
}
