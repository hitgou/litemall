package com.hitgou.common.qwfb.api;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author Colin create on 2019/6/8 <br>
 *         本地存根:
 *         http://dubbo.apache.org/zh-cn/docs/user/demos/local-stub.html<br>
 *         远程服务后，客户端通常只剩下接口，而实现全在服务器端，但提供方有些时候想在客户端也执行部分逻辑，比如：做 ThreadLocal
 *         缓存，提前验证参数，调用失败后伪造容错数据等等，此时就需要在 API 中带上 Stub，客户端生成 Proxy 实例，会把 Proxy
 *         通过构造函数传给 Stub [1]，然后把 Stub 暴露给用户，Stub 可以决定要不要去调 Proxy
 */
@Service(version = "1.0.0")
public class QwfbServiceStub implements QwfbService {
    private final QwfbService providerService;

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${spring.dubbo.application.name}")
    private String serviceName;

    public QwfbServiceStub(QwfbService providerService) {
        this.providerService = providerService;
    }

    @Override
    public String connect(String clientId) {
        clientId += " stub";
        return providerService.connect(clientId);
    }

}