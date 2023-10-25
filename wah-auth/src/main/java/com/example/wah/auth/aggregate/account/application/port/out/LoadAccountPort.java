package com.example.wah.auth.aggregate.account.application.port.out;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;

public interface LoadAccountPort {
    Account loadAccount(String email);
}
