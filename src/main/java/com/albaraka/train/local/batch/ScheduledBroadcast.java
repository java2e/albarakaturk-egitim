package com.albaraka.train.local.batch;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Profile("dev")
@Component
public class ScheduledBroadcast {

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");


    /**
     * Her dakika başında (saniye 0’da) çalışır.
     * Alternatif olarak fixedRate = 60000 kullanabilirsiniz.
     */

    @Scheduled(cron = "${cron.publish.hour}")
    public void publishEveryMinute() {
        System.out.println("BATCH CALISTIRILDI1!!!!!!  "+LocalDateTime.now().toString());
    }






}