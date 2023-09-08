package com.example.wah.auth.aggregate.account.application.service;

import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class AccountService {

    public void signUp(AccountSignUpRequest request) {

    }

    public void signIn() {

    }

}
