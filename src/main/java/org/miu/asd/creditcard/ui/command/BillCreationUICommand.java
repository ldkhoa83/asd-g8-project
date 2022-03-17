package org.miu.asd.creditcard.ui.command;

import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.command.UICommand;

public class BillCreationUICommand implements UICommand<CreditCardUIBean> {
    private AccountService accountService;
    public BillCreationUICommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(CreditCardUIBean bean) {
        String report = accountService.generateMonthlyBillReport(bean.getAccountNumber());
        bean.setMonthlyBillReport(report);
    }
}
