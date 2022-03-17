package org.miu.asd.creditcard.email;

import org.miu.asd.framework.domain.*;
import org.miu.asd.framework.observer.Observer;

public class EmailSender implements Observer {

    @Override
    public void update(AccountEntry accountEntry, Account account) {
        if (accountEntry.getAccountEvent().getAccountEventType() == AccountEventType.CHARGED || accountEntry.getAccountEvent().getAccountEventType() == AccountEventType.DEPOSIT) {
            if (account.getCustomer() instanceof Customer && (accountEntry.getAmountOfMoney() >= 400 || accountEntry.getAmountOfMoney() < 0)) {
                System.out.println("Sending email to: " + account.getCustomer().getEmail() + "In account (" + account.getAccountNumber() + ") amount = \n" + accountEntry.getAmountOfMoney() + " - " + accountEntry.getAccountEvent().getAccountEventType());
//            } else if (account.getCustomer() instanceof Customer)
//                System.out.println("Sending email to: " + account.getCustomer().getEmail() + "In account (" + account.getAccountNumber() + ") amount = \n" + accountEntry.getAmountOfMoney() + " - " + accountEntry.getAccountEvent().getAccountEventType());
            }
        }
    }
}
