package com.kjbin0420.fakeinstagram.Service.auth;

public interface MailService {
    public void sendMail(String subject, String from, String to);
    public boolean emailCheckService(Integer num);
}
