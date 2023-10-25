package com.example.wah.auth.util;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailUtil {
    private final JavaMailSender emailSender;
    @Value("${spring.mail.host}")
    private String fromEmil;
    public void sendMail(String to, String sub, String text) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(fromEmil);
        mailMessage.setTo(to);
        mailMessage.setSubject(sub);
        mailMessage.setText(text);

        emailSender.send(mailMessage);
    }
}
