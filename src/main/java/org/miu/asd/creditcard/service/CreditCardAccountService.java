package org.miu.asd.creditcard.service;

import org.miu.asd.creditcard.email.EmailSender;
import org.miu.asd.framework.dao.AccountDAO;
import org.miu.asd.framework.domain.*;
import org.miu.asd.framework.observer.Observable;
import org.miu.asd.framework.observer.Observer;
import org.miu.asd.framework.service.BaseAccountService;

import java.util.ArrayList;
import java.util.List;

public class CreditCardAccountService extends BaseAccountService implements Observable {

    private List<Observer> observers = new ArrayList<>();

    public CreditCardAccountService(AccountDAO accountDao) {
        super(accountDao);
        this.registerObserver(new EmailSender());
    }

    @Override
    protected void performNotify(AccountEntry accountEntry, Account account) {
        notifyObservers(accountEntry,account);
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
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers(AccountEntry accountEntry, Account account) {
        for (Observer ob: observers){
            ob.update(accountEntry,account);
        }
    }

    @Override
    public void addInterestForAllAccounts() {

    }
}
