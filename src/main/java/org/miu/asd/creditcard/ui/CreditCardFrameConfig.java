package org.miu.asd.creditcard.ui;

import org.miu.asd.creditcard.domain.CreditCardAccount;
import org.miu.asd.framework.ui.FrameConfig;

import java.util.ArrayList;
import java.util.List;

public class CreditCardFrameConfig implements FrameConfig<CreditCardAccount> {
    @Override
    public int getFrameHeight() {
        return 310;
    }

    @Override
    public int getFrameWidth() {
        return 575;
    }

    @Override
    public List<String> getColumnsOfAccountTable() {
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
        return 1;
    }

    @Override
    public int getAccountScrollPanelWidth() {
        return 444;
    }

    @Override
    public int getAccountScrollPanelHeight() {
        return 160;
    }

    @Override
    public int getAccountTableWidth() {
        return 420;
    }

    @Override
    public int getAccountTableHeight() {
        return 0;
    }

    @Override
    public Object[] buildRow(CreditCardAccount account) {
        Object[] rowdata = new Object[5];
        rowdata[0] = account.getCustomer().getName();
        rowdata[1] = account.getAccountNumber();
        rowdata[2] = account.getExpiredDate();
        rowdata[3] = account.getCreditCardType().getName();
        rowdata[4] = account.balance();
        return rowdata;
    }

    @Override
    public int getCustomerNameColumnIndex() {
        return 0;
    }
}
