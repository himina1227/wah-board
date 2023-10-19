package com.example.wah.auth.aggregate.account.application.service;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.application.port.in.SaveAccountUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import com.example.wah.auth.aggregate.account.application.port.out.SaveAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class SaveAccountService implements SaveAccountUseCase {

    private final SaveAccountPort saveAccountPort;
    public void signUpByEmail(AccountSignUpRequest request) {

        Account newAccount = Account.builder().email(request.getEmail()).password(request.getPassword()).activated(true).build();
        saveAccountPort.save(newAccount);

    }

}
