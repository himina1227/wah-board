package com.example.wah.auth.aggregate.account.application.service;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.AuthCode;
import com.example.wah.auth.aggregate.account.application.port.in.VerifyEmailUseCase;
import com.example.wah.auth.aggregate.account.application.port.out.LoadAccountPort;
import com.example.wah.auth.aggregate.account.application.port.out.LoadAuthCodePort;
import com.example.wah.auth.aggregate.account.application.port.out.SaveAccountPort;
import com.example.wah.auth.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerifyEmailService implements VerifyEmailUseCase {

    private final LoadAuthCodePort loadAuthCodePort;
    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;
    @Override
    public Boolean verifyEmail(String email, String key) {

        AuthCode code = loadAuthCodePort.loadAuthCode(email, key)
                .orElseThrow(() -> new RuntimeException("인증 정보가 존재하지 않습니다"));

        LocalDateTime now = LocalDateTime.now();

        if(now.isAfter(code.getExpiredAt())) {
            throw new RuntimeException("인증 유효시간이 만료되었습니다");
        }

        Account account = loadAccountPort.loadAccount(email);

        if(account != null) {
            account.setActivated(true);
            saveAccountPort.save(account);
        } else {
            throw new RuntimeException("계정이 존재하지 않습니다.");
        }
        return true;
    }


}
