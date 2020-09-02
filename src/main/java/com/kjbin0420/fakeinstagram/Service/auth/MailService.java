package com.kjbin0420.fakeinstagram.Service.auth;

public interface MailService {
    public void sendMail(String subject, String text, String from, String to, String filePath);
}
