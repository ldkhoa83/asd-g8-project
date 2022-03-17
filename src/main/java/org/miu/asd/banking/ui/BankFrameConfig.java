package org.miu.asd.banking.ui;

import org.miu.asd.banking.domain.CheckingAccount;
import org.miu.asd.framework.domain.Company;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.ui.FrameConfig;

import java.util.ArrayList;
import java.util.List;

public class BankFrameConfig implements FrameConfig {
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
        columns.add("AccountNr");
        columns.add("Name");
        columns.add("City");
        columns.add("P/C");
        columns.add("Ch/S");
        columns.add("Amount");
        return columns;
    }

    @Override
    public Object[] buildRow(Account account) {
        Object[] rowdata = new Object[6];
        rowdata[0] = account.getAccountNumber();
        rowdata[1] = account.getCustomer().getName();
        rowdata[2] = account.getCustomer().getCity();
        rowdata[3] = account.getCustomer() instanceof Company ? "C" : "P";
        rowdata[4] = account instanceof CheckingAccount ? "Ch" : "S";
        rowdata[5] = account.balance();
        return rowdata;
    }

    @Override
    public int getCustomerNameColumnIndex() {
        return 1;
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


}
