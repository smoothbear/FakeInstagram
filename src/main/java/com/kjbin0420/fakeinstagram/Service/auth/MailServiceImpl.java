package com.kjbin0420.fakeinstagram.Service.auth;

import com.kjbin0420.fakeinstagram.Entity.User.EmailAuthNum;
import com.kjbin0420.fakeinstagram.Repository.User.EmailAuthNumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
    This is mail service class.
    @author kjbin0420
 **/

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;
    private final EmailAuthNumRepository emailAuthNumRepository;

    @Value("${spring.mail.username}")
    private final String sender;
    /**
     * 6 digits number generated and send.
     * Param List
     * @param to Mail's receiver
     **/

    @Override
    @Async
    public void sendMail(String toAddress) {
        MimeMessage message = javaMailSender.createMimeMessage();
        final int number = ThreadLocalRandom.current().nextInt(100000, 1000000);

        emailAuthNumRepository.save(
                EmailAuthNum.builder()
                    .num(number)
                    .createdAt(LocalDateTime.now())
                    .build()
        );

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setSubject("Mail Verification");
            helper.setFrom("FakeInstagram");
            helper.setText(Integer.toString(number));
            helper.setTo(toAddress);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean emailCheckService(Integer num) {
        return emailAuthNumRepository.findByNum(num)
                .map(emailAuthNum -> {
                    emailAuthNumRepository.delete(emailAuthNum);
                    return true;
                })
                .orElse(false);
    }
}