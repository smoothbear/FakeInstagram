package com.kjbin0420.fakeinstagram.Service.auth;

import com.kjbin0420.fakeinstagram.Repository.User.EmailAuthNumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
    * This is email auto-delete class.
    * @author kjbin0420
**/

@Component
@RequiredArgsConstructor
public class MailNumDeleter {
    private EmailAuthNumRepository numRepository;

    @Scheduled(cron = "* 0 * * * * ")
    public void mailDelete() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.minus(2, ChronoUnit.HOURS);

        numRepository.deleteNum(localDateTime);
    }
}
