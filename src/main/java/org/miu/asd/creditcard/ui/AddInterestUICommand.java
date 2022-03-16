package org.miu.asd.creditcard.ui;

import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UICommand;

public class AddInterestUICommand extends UICommand<CreditCardUIBean> {
    public AddInterestUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(CreditCardUIBean bean) {
        getAccountService().addInterest(bean.getAccountNumber());
    }
}
