package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.Customer;

import java.util.Collection;

public interface UICommandBean {
    String getAccountType();

    void setAccountType(String accountType);

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    Customer getCustomer();

    void setCustomer(Customer customer);

    Double getAmount();

    void setAmount(Double amount);

    Collection<Account> getAllAccounts();

    void setAllAccounts(Collection<Account> accounts);
}
