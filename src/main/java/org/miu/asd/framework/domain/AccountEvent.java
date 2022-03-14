package org.miu.asd.framework.domain;

import org.joda.time.LocalDateTime;

public interface AccountEvent {
    LocalDateTime getWhenOccurred();
    String getSourceName();
    AccountEventType getAccountEventType();
}
