package org.miu.asd.banking.ui;

import org.miu.asd.framework.ui.bean.UIBean;
import org.miu.asd.framework.ui.command.UICommand;
import org.miu.asd.framework.ui.UICommandController;

public interface BankUICommandController extends UICommandController {
    void setAddAccountCommad(UICommand<UIBean> addAccountCommad);
    void setAddInterestCommand(UICommand<UIBean> addInterestCommand);
    void setAllAccReportCommand(UICommand<UIBean> allAccReportCommand);
}
