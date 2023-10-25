package com.example.wah.auth.aggregate.account.application.port.in;

public interface VerifyEmailUseCase {
    Boolean verifyEmail(String email, String key);
}
