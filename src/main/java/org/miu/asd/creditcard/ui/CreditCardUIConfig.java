package org.miu.asd.creditcard.ui;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.ui.FrameConfig;

import java.util.ArrayList;
import java.util.List;

public class CreditCardUIConfig implements FrameConfig {
    @Override
    public int getFrameHeight() {
        return 310;
    }

    @Override
    public int getFrameWith() {
        return 575;
    }

    @Override
    public List<String> getColumnsOfContentGrid() {
        List<String> columns = new ArrayList<>();
        columns.add("Name");
        columns.add("CC Number");
        columns.add("Exp Date");
        columns.add("Type");
        columns.add("Balance");
        return columns;
    }

    @Override
    public int getAccountNumberColumnIndex() {
        return 0;
    }

    @Override
    public int getContentScrollPanelWidth() {
        return 444;
    }

    @Override
    public int getContentScrollPanelHeight() {
        return 160;
    }

    @Override
    public int getContentGridWith() {
        return 420;
    }

    @Override
    public int getContentGridHeight() {
        return 0;
    }

    @Override
    public Object[] buildRow(Account account) {
        return new Object[0];
    }

    @Override
    public int getCustomerNameColumnIndex() {
        return 0;
    }
}
