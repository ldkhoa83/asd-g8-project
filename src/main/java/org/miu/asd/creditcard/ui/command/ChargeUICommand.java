package org.miu.asd.creditcard.ui.command;

import org.joda.time.LocalDateTime;
import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.command.UICommand;

public class ChargeUICommand implements UICommand<CreditCardUIBean> {
    private AccountService accountService;

    public ChargeUICommand(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute(CreditCardUIBean bean) {
        AccountEvent accountEvent = new AccountEvent(LocalDateTime.now(),"Unknown", AccountEventType.CHARGED);
        accountService.charge(bean.getAccountNumber(),bean.getAmount(),accountEvent);
    }
}
