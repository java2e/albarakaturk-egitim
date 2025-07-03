package com.albaraka.train.local.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BroadcastService {

    private final SimpMessagingTemplate template;

    @Autowired
    public BroadcastService(SimpMessagingTemplate template) {
        this.template = template;
    }

    /**
     * Servis katmanından istediğiniz anda tüm abonelere mesaj yayınlar.
     */
    public void broadcast(BroadcastMessage msg) {
        msg.setSentAt(LocalDateTime.now());
        template.convertAndSend("/topic/messages", msg);
    }
}
