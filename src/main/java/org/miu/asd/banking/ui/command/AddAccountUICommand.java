package org.miu.asd.banking.ui.command;

import org.miu.asd.banking.domain.CheckingAccountFactory;
import org.miu.asd.banking.domain.SavingAccountFactory;
import org.miu.asd.banking.ui.AccountType;
import org.miu.asd.framework.domain.AccountFactory;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.UIBean;
import org.miu.asd.framework.ui.command.UICommand;

public class AddAccountUICommand extends UICommand<UIBean> {
    public AddAccountUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        AccountFactory accountFactory = bean.getAccountType().equals(AccountType.CHECKING.getName()) ? new CheckingAccountFactory() : new SavingAccountFactory();
        getAccountService().createAccount(bean.getAccountNumber(),bean.getCustomer(),accountFactory);
    }
}
