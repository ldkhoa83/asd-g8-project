package org.miu.asd.framework.ui;

import org.joda.time.LocalDateTime;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.domain.BasicAccountEvent;
import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.service.AccountService;

public class DepositUICommand extends UICommand<UIBean> {
    public DepositUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(UIBean bean) {
        AccountEvent accountEvent = new BasicAccountEvent(LocalDateTime.now(),bean.getCustomer().getName(), AccountEventType.DEPOSIT);
        getAccountService().deposit(bean.getAccountNumber(),bean.getAmount(),accountEvent);
    }
}
