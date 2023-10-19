package com.example.wah.auth.aggregate.account.adapter.in.rest;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.application.port.in.LoadAccountUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.SaveAccountUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInRequest;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInResponse;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Account", description="사용자 관리를 위한 API입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth/account")
public class AccountController {
    private final SaveAccountUseCase saveAccountUseCase;
    private final LoadAccountUseCase loadAccountUseCase;

    @Operation(summary = "user 등록", description = "user 신규 등록합니다.")
    @PostMapping("/sign-up")
    public void signUp(@RequestBody AccountSignUpRequest request) {
        saveAccountUseCase.signUpByEmail(request);
    }

    @Operation(summary = "user 로그인", description = "user 로그인시 사용합니다.")
    @PostMapping("/sign-in")
    public AccountSignInResponse signIn(@RequestBody AccountSignInRequest request) {
        return loadAccountUseCase.signInByEmail(request);
    }
}
