package org.miu.asd.creditcard.domain;

import org.miu.asd.banking.domain.Person;
import org.miu.asd.framework.domain.Account;
import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.domain.Observer;
import org.miu.asd.framework.service.BasicAccountService;

public class EmailSender implements Observer {


    private BasicAccountService basicAccountService;
    @Override
    public void update() {
        if (basicAccountService.getAccountEventType() == AccountEventType.CHARGED || basicAccountService.getAccountEventType() == AccountEventType.DEPOSIT) {
            Account account = basicAccountService.getCurrentAccount();
            double amount = basicAccountService.getChangedAmount();
            if (account.getCustomer() instanceof Person && (amount <= 400 || account.balance() > 0)) {
                return;
            }
            System.out.println("Sending email to: " + account.getCustomer().getEmail() + " Operation in account (" + account.getAccountNumber() + ") amount = \n" + amount + " - " + basicAccountService.getAccountEventType());
        }
    }
}
