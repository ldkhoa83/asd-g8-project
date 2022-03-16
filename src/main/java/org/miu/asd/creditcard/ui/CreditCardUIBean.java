package org.miu.asd.creditcard.ui;

import org.miu.asd.creditcard.domain.CreditCardType;
import org.miu.asd.framework.ui.UIBean;

public class CreditCardUIBean extends UIBean {
    private String monthlyBillReport;
    private String expiredDate;
    private CreditCardType creditCardType;

    public String getMonthlyBillReport() {
        return monthlyBillReport;
    }

    public void setMonthlyBillReport(String monthlyBillReport) {
        this.monthlyBillReport = monthlyBillReport;
    }

    public void setExpDate(String expDate) {
        this.expiredDate = expDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }
}
