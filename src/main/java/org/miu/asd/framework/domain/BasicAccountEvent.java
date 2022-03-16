package org.miu.asd.framework.domain;

import org.joda.time.LocalDateTime;

public class BasicAccountEvent implements AccountEvent{
    private LocalDateTime whenOccurred;
    private String sourceName;
    private AccountEventType accountEventType;

    public BasicAccountEvent(LocalDateTime whenOccurred, String sourceName, AccountEventType accountEventType) {
        this.whenOccurred = whenOccurred;
        this.sourceName = sourceName;
        this.accountEventType = accountEventType;
    }

    @Override
    public LocalDateTime getWhenOccurred() {
        return null;
    }

    @Override
    public String getSourceName() {
        return null;
    }

    @Override
    public AccountEventType getAccountEventType() {
        return null;
    }
}
