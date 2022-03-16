package org.miu.asd.banking.ui;

import org.miu.asd.banking.service.BankAccountService;
import org.miu.asd.creditcard.ui.CreditCardUIBean;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

public class ReportCreationUICommand extends UICommand<UIBean> {
    public ReportCreationUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        String report = getAccountService().generateAllAccountReports();
        bean.setAllAccountsReport(report);
    }
}
