package me.powerarc.eternalgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EternalGgApplication {

    public static void main(String[] args) {
        SpringApplication.run(EternalGgApplication.class, args);
    }

}
