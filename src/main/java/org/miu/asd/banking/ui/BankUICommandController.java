package org.miu.asd.banking.ui;

import org.miu.asd.framework.ui.bean.BaseUIBean;
import org.miu.asd.framework.ui.command.UICommand;
import org.miu.asd.framework.ui.UICommandController;

public interface BankUICommandController extends UICommandController {
    void setAddAccountCommand(UICommand<BaseUIBean> addAccountCommand);
    void setAddInterestCommand(UICommand<BaseUIBean> addInterestCommand);
    void setAllAccReportCommand(UICommand<BaseUIBean> allAccReportCommand);
}
