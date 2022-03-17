package org.miu.asd.framework.domain;

import org.joda.time.LocalDateTime;

public class AccountEvent {
    private LocalDateTime whenOccurred;
    private String sourceName;
    private AccountEventType accountEventType;

    public AccountEvent(LocalDateTime whenOccurred, String sourceName, AccountEventType accountEventType) {
        this.whenOccurred = whenOccurred;
        this.sourceName = sourceName;
        this.accountEventType = accountEventType;
    }

    public LocalDateTime getWhenOccurred() {
        return whenOccurred;
    }

    public String getSourceName() {
        return sourceName;
    }

    public AccountEventType getAccountEventType() {
        return accountEventType;
    }
}
