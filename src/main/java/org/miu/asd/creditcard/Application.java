package org.miu.asd.creditcard;

import org.miu.asd.creditcard.service.CreditCardAccountService;
import org.miu.asd.creditcard.ui.CreditCardMainFrame;
import org.miu.asd.creditcard.ui.CreditCardUIConfig;
import org.miu.asd.framework.dao.MemoryAccountDAO;

public class Application {
    public static void main(String[] args) {
        CreditCardAccountService service = new CreditCardAccountService(new MemoryAccountDAO());
        CreditCardMainFrame creditCardMainFrame = new CreditCardMainFrame(service, new CreditCardUIConfig(), "Credit Card Application.");
        creditCardMainFrame.setVisible(true);
    }

}
