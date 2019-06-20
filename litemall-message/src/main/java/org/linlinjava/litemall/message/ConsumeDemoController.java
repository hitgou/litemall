package org.linlinjava.litemall.message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hitgou.common.qwfb.api.QwfbService;

@RestController
@RequestMapping("/message")
public class ConsumeDemoController {

    @Reference(version = "1.0.0", stub = "com.hitgou.common.qwfb.api.QwfbServiceStub")
    private QwfbService qwfbServiceStub;

    @GetMapping("/connect")
    public Object connect() {

        return qwfbServiceStub.connect("mercyblitz");
    }

}
