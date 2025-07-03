package com.albaraka.train.local.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BroadcastMessage {
    private String from;
    private String text;
    private LocalDateTime sentAt;
}