package com.albaraka.train.local.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledBroadcast {

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");


    /**
     * Her dakika başında (saniye 0’da) çalışır.
     * Alternatif olarak fixedRate = 60000 kullanabilirsiniz.
     */
    @Scheduled(cron = "0 * * * * *")
    public void publishEveryMinute() {
        System.out.println("BATCH CALISTIRILDI1!!!!!!  "+LocalDateTime.now().toString());
    }
}