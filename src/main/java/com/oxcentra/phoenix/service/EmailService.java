package com.oxcentra.phoenix.service;

public interface EmailService {
    public Boolean sendEmail(String toEmail,
                                String body,
                                String subject);
}
