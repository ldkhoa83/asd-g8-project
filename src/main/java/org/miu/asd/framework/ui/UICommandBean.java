package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Customer;

public interface UICommandBean {
    String getAccountType();

    void setAccountType(String accountType);

    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    Customer getCustomer();

    void setCustomer(Customer customer);

    Double getAmount();

    void setAmount(Double amount);
}
