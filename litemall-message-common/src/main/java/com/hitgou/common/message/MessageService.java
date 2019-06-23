package com.hitgou.common.message;

import java.util.concurrent.CompletableFuture;

public interface MessageService {
    String priceChanged(String newPrice);

//    CompletableFuture<String> sendToClient(Integer userId, String eventType, String message,
//            BusinessCallback businessCallback);
}