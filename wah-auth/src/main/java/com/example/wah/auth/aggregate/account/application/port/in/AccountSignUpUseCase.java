package com.example.wah.auth.aggregate.account.application.port.in;

import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import jakarta.mail.MessagingException;

public interface AccountSignUpUseCase {
    void signUpByEmail(AccountSignUpRequest request) throws MessagingException;
}
