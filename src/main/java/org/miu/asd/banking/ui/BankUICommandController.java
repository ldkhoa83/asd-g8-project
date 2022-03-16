package org.miu.asd.banking.ui;

import org.miu.asd.creditcard.ui.CreditCardUIBean;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;
import org.miu.asd.framework.ui.UICommandController;

public interface BankUICommandController extends UICommandController {
    void setAddAccountCommad(UICommand<UIBean> addAccountCommad);
    void setAddInterestCommand(UICommand<UIBean> addInterestCommand);
}
