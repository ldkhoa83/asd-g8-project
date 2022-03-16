package org.miu.asd.framework.domain;

public enum BasicAccountEventType implements AccountEventType{
    NONE{
        @Override
        public String getDescription() {
            return "";
        }
    },
    DEPOSIT{
        @Override
        public String getDescription() {
            return "Deposit";
        }
    },
    WITHDRAW{
        @Override
        public String getDescription() {
            return "Withdraw";
        }
    };

}
