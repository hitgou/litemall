package org.linlinjava.litemall.qwfb.vm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;

public class PublishAccountGroupVM implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Integer AccountGroupId;
    public String AccountGroupName;
    public List<PublishAccountVM> AccountList;
    public Map<Integer, PlatformVM> PlatformMaps;

    public static class PublishAccountVM {
        public Integer AccountId;
        public String AccountName;
        public Integer PlatformId;
        public String PlatformName;

        public PublishAccountVM fromAccountDB(LitemallQwfbAccount accountDB) {
            PublishAccountVM account = new PublishAccountVM();
            account.AccountId = accountDB.getId();
            account.AccountName = accountDB.getShowName();
            account.PlatformId = accountDB.getPlatformId();

            return account;
        }
    }

    public static class PlatformVM {
        public Integer PlatformId;
        public String PlatformName;
        public String HeadIcon;
        public String ShortName;
    }

}
