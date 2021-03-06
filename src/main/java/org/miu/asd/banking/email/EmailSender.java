package org.miu.asd.banking.email;

import org.miu.asd.framework.domain.*;
import org.miu.asd.framework.observer.Observer;

public class EmailSender implements Observer {

    @Override
    public void update(AccountEntry accountEntry, Account account) {
        if (accountEntry.getAccountEvent().getAccountEventType() == AccountEventType.WITHDRAW || accountEntry.getAccountEvent().getAccountEventType() == AccountEventType.DEPOSIT) {
            if (account.getCustomer() instanceof Person && (accountEntry.getAmountOfMoney() >= 500 || account.balance() < 0)) {
                System.out.println("Sending email to: " + account.getCustomer().getName() + " Operation in account (" + account.getAccountNumber() + ") amount = \n" + accountEntry.getAmountOfMoney() + " - " + accountEntry.getAccountEvent().getAccountEventType());
            }else if (account.getCustomer() instanceof Company)
                System.out.println("Sending email to: " + account.getCustomer().getName() + " Operation in account (" + account.getAccountNumber() + ") amount = \n" + accountEntry.getAmountOfMoney() + " - " + accountEntry.getAccountEvent().getAccountEventType());
        }
    }
}
