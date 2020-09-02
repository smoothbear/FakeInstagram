package com.kjbin0420.fakeinstagram.Controller;

import com.kjbin0420.fakeinstagram.Service.auth.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final MailService mailService;

    @GetMapping("/checkVerification")
    public boolean checkVerification(Integer code) {
        return mailService.emailCheckService(code);
    }

    @GetMapping("/emailSend")
    public void emailSend(@Email String toAddress) {
        mailService.sendMail(toAddress);
    }
}
