package org.miu.asd.framework.ui.command;

import org.joda.time.LocalDateTime;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.bean.BaseUIBean;

public class DepositUICommand implements UICommand<BaseUIBean> {
    private AccountService accountService;

    public DepositUICommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(BaseUIBean bean) {
        AccountEvent accountEvent = new AccountEvent(LocalDateTime.now(),bean.getCustomer().getName(), AccountEventType.DEPOSIT);
        accountService.deposit(bean.getAccountNumber(),bean.getAmount(),accountEvent);
    }
}
