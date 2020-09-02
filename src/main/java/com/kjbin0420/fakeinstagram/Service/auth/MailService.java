package com.kjbin0420.fakeinstagram.Service.auth;

public interface MailService {
    public void sendMail(String toAddress);
    public boolean emailCheckService(Integer num);
}
