package com.albaraka.train.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // "/topic" ile başlayan destination'lara abonelik yapılabilir
        config.enableSimpleBroker("/topic");
        // uygulama içinden gönderilen mesajlar "/app" prefix'ine sahip olur
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // istemcinin bağlanacağı endpoint ve CORS izinleri
        registry.addEndpoint("/ws")
                // CORS wildcard ama allowCredentials ile uyumlu
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}