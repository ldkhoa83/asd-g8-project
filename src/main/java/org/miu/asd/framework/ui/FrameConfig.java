package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Account;

import java.util.List;

public interface FrameConfig<T extends Account> {
    int getFrameHeight();

    int getFrameWidth();

    List<String> getColumnsOfAccountTable();

    int getAccountNumberColumnIndex();

    int getAccountScrollPanelWidth();

    int getAccountScrollPanelHeight();

    int getAccountTableWidth();

    int getAccountTableHeight();

    Object[] buildRow(T account);

    int getCustomerNameColumnIndex();
}
