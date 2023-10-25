package com.example.wah.auth.aggregate.account.application.port.out;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.AuthCode;

public interface SaveAuthCodePort {
    void save(AuthCode authCode);
}
