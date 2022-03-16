package org.miu.asd.banking.domain;

import org.miu.asd.framework.domain.AccountEventType;
import org.miu.asd.framework.domain.Observer;
import org.miu.asd.framework.service.BasicAccountService;

public class EmailSender implements Observer {


    private BasicAccountService basicAccountService;
    @Override
    public void update() {
 //to be implemented
    }
}
