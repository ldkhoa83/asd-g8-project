package org.miu.asd.banking;

import org.miu.asd.banking.service.BankAccountService;
import org.miu.asd.banking.ui.BankMainFrame;
import org.miu.asd.banking.ui.BankMainFrameConfig;
import org.miu.asd.framework.dao.MemoryAccountDAO;

public class Application {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountService(new MemoryAccountDAO());
        BankMainFrame bankMainFrame = new BankMainFrame(bankAccountService, new BankMainFrameConfig(), "Bank Application.");
        bankMainFrame.setVisible(true);
    }
}
