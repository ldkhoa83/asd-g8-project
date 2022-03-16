package org.miu.asd.creditcard.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UICommand;
import org.miu.asd.framework.ui.UICommandBean;

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
