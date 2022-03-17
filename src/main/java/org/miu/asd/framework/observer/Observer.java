package org.miu.asd.framework.observer;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEntry;

public interface Observer {
    void update(AccountEntry accountEntry, Account account);
}
