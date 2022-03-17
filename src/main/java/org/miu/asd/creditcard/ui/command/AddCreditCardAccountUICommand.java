package org.miu.asd.creditcard.ui.command;

import org.miu.asd.creditcard.service.CreditCardAccountFactory;
import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.command.UICommand;

public class AddCreditCardAccountUICommand implements UICommand<CreditCardUIBean> {
    AccountService accountService;

    public AddCreditCardAccountUICommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(CreditCardUIBean bean) {
        CreditCardAccountFactory accountFactory = new CreditCardAccountFactory(bean.getExpiredDate(),bean.getCreditCardType());
        accountService.createAccount(bean.getAccountNumber(),bean.getCustomer(),accountFactory);
    }
}
