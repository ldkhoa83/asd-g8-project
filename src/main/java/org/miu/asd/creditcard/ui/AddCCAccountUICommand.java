package org.miu.asd.creditcard.ui;

import org.miu.asd.creditcard.service.CreditCardAccountFactory;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UICommand;
import org.miu.asd.framework.ui.UICommandBean;

public class AddCCAccountUICommand extends UICommand<CreditCardUIBean> {
    public AddCCAccountUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(CreditCardUIBean bean) {
        CreditCardAccountFactory accountFactory = new CreditCardAccountFactory(bean.getExpiredDate(),bean.getCreditCardType());
        getAccountService().createAccount(bean.getAccountNumber(),bean.getCustomer(),accountFactory);
    }
}
