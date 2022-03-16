package org.miu.asd.framework.domain;

import org.joda.time.LocalDateTime;

public class BaseAccountEvent implements AccountEvent{
    private LocalDateTime whenOccurred;
    private String sourceName;
    private AccountEventType accountEventType;

    public BaseAccountEvent(LocalDateTime whenOccurred, String sourceName, AccountEventType accountEventType) {
        this.whenOccurred = whenOccurred;
        this.sourceName = sourceName;
        this.accountEventType = accountEventType;
    }

    @Override
    public LocalDateTime getWhenOccurred() {
        return whenOccurred;
    }

    @Override
    public String getSourceName() {
        return sourceName;
    }

    @Override
    public AccountEventType getAccountEventType() {
        return accountEventType;
    }
}
