
package org.linlinjava.litemall.qwfb.message;

import java.io.Serializable;

import com.hitgou.common.message.CallbackListener;

/**
 * @author Colin create on 2019/6/8
 */
public class CallbackListenerImpl2 implements CallbackListener, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6507518823572130484L;

    public CallbackListenerImpl2() {

    }

    @Override
    public void changed(String msg) {
        System.out.println("callback:" + msg);
    }

}
