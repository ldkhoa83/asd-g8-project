package org.miu.asd.banking.ui;

import org.miu.asd.creditcard.ui.CreditCardUIBean;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

public class AddInterestUICommand extends UICommand<UIBean> {
    public AddInterestUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
    }
}
