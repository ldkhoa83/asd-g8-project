package org.miu.asd.banking.domain;

import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.domain.Observer;
import org.miu.asd.framework.service.BasicAccountService;

public class EmailSender implements Observer {

    private BasicAccountService basicAccountService;
    @Override
    public void update() {
        if (basicAccountService.getAccountEventType() == AccountEventType.WITHDRAW || basicAccountService.getAccountEventType() == AccountEventType.DEPOSIT) {
            Account account = basicAccountService.getCurrentAccount();
            double amount = basicAccountService.getChangedAmount();
            if (account.getCustomer() instanceof Person && (amount <= 500 || account.balance() > 0)) {
                return;
            }
            System.out.println("Sending email to: " + account.getCustomer().getEmail() + " Operation in account (" + account.getAccountNumber() + ") amount = \n" + amount + " - " + basicAccountService.getAccountEventType());
        }
    }
}
