package org.miu.asd.framework.ui;

import org.miu.asd.framework.domain.Account;

import java.util.List;

public interface FrameConfig<T extends Account> {
    int getFrameHeight();

    int getFrameWith();

    List<String> getColumnsOfContentGrid();

    int getAccountNumberColumnIndex();

    int getContentScrollPanelWidth();

    int getContentScrollPanelHeight();

    int getContentGridWith();

    int getContentGridHeight();

    Object[] buildRow(T account);

    int getCustomerNameColumnIndex();
}
