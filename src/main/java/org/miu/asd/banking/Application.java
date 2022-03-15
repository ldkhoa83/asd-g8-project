package org.miu.asd.banking.ui;

import org.miu.asd.banking.service.BankAccountService;
import org.miu.asd.framework.dao.MemoryAccountDAO;

public class Application {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountService(new MemoryAccountDAO());
        BankMainFrame bankMainFrame = new BankMainFrame(bankAccountService, new BankMainFrameConfig());
        bankMainFrame.init("AAA");
        bankMainFrame.setVisible(true);
    }
}
