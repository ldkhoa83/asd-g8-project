package org.miu.asd.banking.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.BaseUIBean;
import org.miu.asd.framework.ui.command.UICommand;

public class ReportCreationUICommand implements UICommand<BaseUIBean> {
    private AccountService accountService;

    public ReportCreationUICommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(BaseUIBean bean) {
        String report = accountService.generateAllAccountReports();
        bean.setAllAccountsReport(report);
    }
}
