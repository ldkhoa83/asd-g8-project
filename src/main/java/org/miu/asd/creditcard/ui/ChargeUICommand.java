package org.miu.asd.creditcard.ui;

import org.joda.time.LocalDateTime;
import org.miu.asd.framework.domain.AccountEvent;
import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.domain.BasicAccountEvent;
import org.miu.asd.framework.service.AccountService;
import org.miu.asd.framework.ui.UICommand;

public class ChargeUICommand extends UICommand<CreditCardUIBean> {
    public ChargeUICommand(AccountService accountService) {
        super(accountService);
    }

    @Override
    public void execute(CreditCardUIBean bean) {
        AccountEvent accountEvent = new BasicAccountEvent(LocalDateTime.now(),"Unknown", AccountEventType.CHARGED);
        getAccountService().charge(bean.getAccountNumber(),bean.getAmount(),accountEvent);
    }
}
