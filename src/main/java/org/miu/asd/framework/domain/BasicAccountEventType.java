package org.miu.asd.framework.domain;

public enum BasicAccountEventType implements AccountEventType{
    NONE{
        @Override
        public String getDescription() {
            return "";
        }
    };

}
