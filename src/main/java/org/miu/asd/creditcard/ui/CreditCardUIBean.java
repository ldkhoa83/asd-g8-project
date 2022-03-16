package org.miu.asd.creditcard.ui;

import org.joda.time.LocalDate;
import org.miu.asd.creditcard.domain.CreditCardType;
import org.miu.asd.framework.domain.Customer;
import org.miu.asd.framework.ui.UIBean;
import org.miu.asd.framework.ui.UICommandBean;

public class CreditCardUIBean implements UICommandBean {
    private UIBean uiBean = new UIBean();
    private String monthlyBillReport;
    private LocalDate expiredDate;
    private CreditCardType creditCardType;

    public String getMonthlyBillReport() {
        return monthlyBillReport;
    }

    public void setMonthlyBillReport(String monthlyBillReport) {
        this.monthlyBillReport = monthlyBillReport;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public UIBean getUiBean() {
        return uiBean;
    }

    public void setUiBean(UIBean uiBean) {
        this.uiBean = uiBean;
    }

    @Override
    public String getAccountType() {
        return getUiBean().getAccountType();
    }

    @Override
    public void setAccountType(String accountType) {
        getUiBean().setAccountType(accountType);
    }

    @Override
    public String getAccountNumber() {
        return getUiBean().getAccountNumber();
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        getUiBean().setAccountNumber(accountNumber);
    }

    @Override
    public Customer getCustomer() {
        return getUiBean().getCustomer();
    }

    @Override
    public void setCustomer(Customer customer) {
        getUiBean().setCustomer(customer);
    }

    @Override
    public Double getAmount() {
        return getUiBean().getAmount();
    }

    @Override
    public void setAmount(Double amount) {
        getUiBean().setAmount(amount);
    }
}
