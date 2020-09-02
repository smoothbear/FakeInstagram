package com.kjbin0420.fakeinstagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class FakeinstagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(FakeinstagramApplication.class, args);
    }

}
