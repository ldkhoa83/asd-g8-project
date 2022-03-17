package org.miu.asd.creditcard.ui.command;

import org.joda.time.LocalDateTime;
import org.miu.asd.creditcard.ui.bean.CreditCardUIBean;
import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.command.UICommand;

public class ChargeUICommand extends UICommand<CreditCardUIBean> {
    public ChargeUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(CreditCardUIBean bean) {
        AccountEvent accountEvent = new AccountEvent(LocalDateTime.now(),"Unknown", AccountEventType.CHARGED);
        getAccountService().charge(bean.getAccountNumber(),bean.getAmount(),accountEvent);
    }
}
