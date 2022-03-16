package org.miu.asd.banking.service;

import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.miu.asd.banking.domain.EmailSender;
import org.miu.asd.framework.dao.AccountDAO;
import org.miu.asd.framework.domain.*;
import org.miu.asd.framework.service.BasicAccountService;

import java.util.ArrayList;
import java.util.List;

public class BankAccountService extends BasicAccountService implements Observable {

    private List<Observer> observers = new ArrayList<>();

    public BankAccountService(AccountDAO accountDao) {
        super(accountDao);
        this.registerObserver(new EmailSender());
    }

//        public void addInterestForAllAccounts() {
//        getAccountDAO().loadAllAccounts().forEach( a -> {
//            AccountEntry accountEntry = a.addInterest();
//             accountDAO.updateAccount(account);
//             notifyObservers();
//        });
//    }
    @Override
    protected void performNotify(AccountEntry accountEntry, Account account) {
        notifyObservers(accountEntry, account);
    }

    protected AccountEntry performWithdrawOnAccount(Account account, Double amountOfMoney, AccountEvent
            accountEvent) {
        return account.withdraw(amountOfMoney, accountEvent);
    }

    @Override
    protected AccountEntry performDepositOnAccount(Account account, Double amountOfMoney, AccountEvent accountEvent) {
        return account.deposit(amountOfMoney, accountEvent);
    }



    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(AccountEntry accountEntry, Account account) {
        for (Observer ob : observers) {
            ob.update(accountEntry, account);
        }
    }


    @Override
    public void addInterestForAllAccounts() {

    }
}
