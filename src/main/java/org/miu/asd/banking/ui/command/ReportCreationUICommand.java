package org.miu.asd.banking.ui.command;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.BaseUIBean;
import org.miu.asd.framework.ui.command.UICommand;

public class ReportCreationUICommand extends UICommand<BaseUIBean> {
    public ReportCreationUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(BaseUIBean bean) {
        String report = getAccountService().generateAllAccountReports();
        bean.setAllAccountsReport(report);
    }
}
