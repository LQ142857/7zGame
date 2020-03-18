package com.a7z.sevenzgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SevenzgameApplication {

    public static void main(String[] args) {
        SpringApplication.run(SevenzgameApplication.class, args);
    }

}
