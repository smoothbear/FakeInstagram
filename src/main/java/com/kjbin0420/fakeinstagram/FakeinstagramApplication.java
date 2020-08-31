package com.kjbin0420.fakeinstagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FakeinstagramApplication {

    public static void main(String[] args) {
        SpringApplication.run(FakeinstagramApplication.class, args);
    }

}
