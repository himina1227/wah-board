package com.example.wah.auth.aggregate.account.application.service;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.AuthCode;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Authority;
import com.example.wah.auth.aggregate.account.application.port.in.AccountSignUpUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import com.example.wah.auth.aggregate.account.application.port.out.LoadAccountPort;
import com.example.wah.auth.aggregate.account.application.port.out.SaveAccountPort;
import com.example.wah.auth.aggregate.account.application.port.out.SaveAuthCodePort;
import com.example.wah.auth.util.EmailUtil;
import com.example.wah.auth.util.RedisUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class AccountSignUpService implements AccountSignUpUseCase {

    private final SaveAccountPort saveAccountPort;
    private final PasswordEncoder passwordEncoder;
    private final LoadAccountPort loadAccountPort;
    private final SaveAuthCodePort saveAuthCodePort;

    //private final RedisUtil redisUtil;
    private final EmailUtil emailUtil;
    public void signUpByEmail(AccountSignUpRequest request) throws MessagingException {

        UUID uuid = UUID.randomUUID();
        String LINK = "http://localhost:8100/api/auth/account/verify-code/"+request.getEmail()+"/"+uuid.toString();

        if(loadAccountPort.loadAccount(request.getEmail()) != null) {
            throw new RuntimeException("이미 가입된 Email입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Account newAccount = Account.builder()
                .name(request.getName())
                .email(request.getEmail())
                .authorities(Collections.singleton(authority))
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        AuthCode authCode = AuthCode.builder()
                .code(uuid.toString())
                .email(request.getEmail())
                .build();

        saveAuthCodePort.save(authCode);
        saveAccountPort.save(newAccount);


        //redisUtil.setDataExpire(uuid.toString(), newAccount.getEmail(), 60*30L);
        emailUtil.sendMail(request.getEmail(), "게시판 서비스 회원가입 인증메일입니다,", LINK);

    }

}
