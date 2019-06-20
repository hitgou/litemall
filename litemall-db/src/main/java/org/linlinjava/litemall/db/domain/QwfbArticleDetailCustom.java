package org.linlinjava.litemall.db.domain;

import java.io.Serializable;

public class QwfbArticleDetailCustom extends LitemallQwfbArticleDetail implements Serializable {

    private String accountName;
    private Byte type;
    private int coverMode;

    private static final long serialVersionUID = 1L;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public int getCoverMode() {
        return coverMode;
    }

    public void setCoverMode(int coverMode) {
        this.coverMode = coverMode;
    }

}