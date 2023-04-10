package com.oxcentra.phoenix.service;

public interface EmailService {
    public Boolean sendVerificationCode(String toEmail,
                                String body,
                                String subject);
}
