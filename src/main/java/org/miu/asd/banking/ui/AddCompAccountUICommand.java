package org.miu.asd.banking.ui;

import org.miu.asd.banking.service.BankAccountService;
import org.miu.asd.banking.service.CheckingAccountFactory;
import org.miu.asd.banking.service.SavingAccountFactory;
import org.miu.asd.framework.service.AccountFactory;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommand;

public class AddCompAccountUICommand extends UICommand<BankAccountService> {
    public AddCompAccountUICommand(BankAccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        AccountFactory accountFactory = bean.getAccountType().equals(AccountType.CHECKING) ? new CheckingAccountFactory() : new SavingAccountFactory();
        getAccountService().createAccount(bean.getAccountNumber(),bean.getCustomer(),accountFactory);
    }
}
