package org.miu.asd.framework.ui;

import org.joda.time.LocalDateTime;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.domain.BasicAccountEvent;
import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.service.AccountService;

public class WithdrawUICommand extends UICommand<UIBean>{
    public WithdrawUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        AccountEvent accountEvent = new BasicAccountEvent(LocalDateTime.now(),bean.getCustomer().getName(), AccountEventType.WITHDRAW);
        getAccountService().withdraw(bean.getAccountNumber(),bean.getAmount(),accountEvent);
    }
}
