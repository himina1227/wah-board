package com.example.wah.auth.aggregate.account.application.service;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Authority;
import com.example.wah.auth.aggregate.account.application.port.in.SaveAccountUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import com.example.wah.auth.aggregate.account.application.port.out.LoadAccountPort;
import com.example.wah.auth.aggregate.account.application.port.out.SaveAccountPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

@Transactional
@RequiredArgsConstructor
@Service
public class SaveAccountService implements SaveAccountUseCase {

    private final SaveAccountPort saveAccountPort;
    private final PasswordEncoder passwordEncoder;
    private final LoadAccountPort loadAccountPort;
    private final JavaMailSender mailSender;
    public void signUpByEmail(AccountSignUpRequest request) throws MessagingException {

        if(loadAccountPort.loadAccount(request.getEmail()) != null) {
            throw new RuntimeException("이미 가입된 Email입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_NOT_PERMIT")
                .build();

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        String LINK = "http://localhost:8100/account/verify-code";
        UUID uuid = UUID.randomUUID();

        helper.setTo(request.getEmail());
        helper.setSubject("게시판 서비스 인증코드");
        helper.setText("");

        Account newAccount = Account.builder()
                .name(request.getName())
                .email(request.getEmail())
                .authorities(Collections.singleton(authority))
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        saveAccountPort.save(newAccount);

    }

}
