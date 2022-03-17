package org.miu.asd.framework.observer;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEntry;

public interface Observable {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(AccountEntry accountEntry, Account account);
}
