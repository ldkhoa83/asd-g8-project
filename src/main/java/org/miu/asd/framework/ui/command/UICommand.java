package org.miu.asd.framework.ui.command;

import org.miu.asd.framework.ui.bean.UICommandBean;

public interface UICommand<T extends UICommandBean> {

    void execute(T bean);

}
