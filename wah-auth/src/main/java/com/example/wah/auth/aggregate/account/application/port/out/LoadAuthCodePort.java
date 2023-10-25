package com.example.wah.auth.aggregate.account.application.port.out;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.AuthCode;

import java.util.Optional;

public interface LoadAuthCodePort {
    Optional<AuthCode> loadAuthCode(String email, String code);
}
