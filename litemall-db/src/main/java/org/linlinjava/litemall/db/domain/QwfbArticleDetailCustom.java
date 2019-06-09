package org.linlinjava.litemall.db.domain;

import java.io.Serializable;

public class QwfbArticleDetailCustom extends LitemallQwfbArticleDetail implements Serializable {

    private String accountName;
    private int type;

    private static final long serialVersionUID = 1L;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}