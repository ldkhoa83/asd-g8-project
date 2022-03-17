package org.miu.asd.creditcard.ui.command;

import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.command.UICommand;

public class BillCreationUICommand extends UICommand<CreditCardUIBean> {
    public BillCreationUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(CreditCardUIBean bean) {
        String report = getAccountService().generateMonthlyBillReport(bean.getAccountNumber());
        bean.setMonthlyBillReport(report);
    }
}
