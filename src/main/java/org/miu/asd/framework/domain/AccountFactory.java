package org.miu.asd.framework.domain;

public interface AccountFactory {
    Account initAccount(String accountNumber, Customer customer);
}
