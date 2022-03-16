package org.miu.asd.framework.domain;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;

public interface AccountFactory {
    Account initAccount(String accountID, Customer customer);
}
