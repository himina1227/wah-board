package com.example.wah.auth.aggregate.account.adapter.in.rest;

import com.example.wah.auth.aggregate.account.application.port.in.AccountSignInUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.AccountSignUpUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.VerifyEmailUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInRequest;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInResponse;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name="Account", description="사용자 관리를 위한 API입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth/account")
public class AccountController {
    private final AccountSignUpUseCase accountSignUpUseCase;
    private final AccountSignInUseCase accountSignInUseCase;
    private final VerifyEmailUseCase verifyEmaillUseCase;

    @Operation(summary = "user 등록", description = "user 신규 등록합니다.")
    @PostMapping("/sign-up")
    public void signUp(@RequestBody AccountSignUpRequest request) throws MessagingException {
        accountSignUpUseCase.signUpByEmail(request);
    }

    @Operation(summary = "user 로그인", description = "user 로그인시 사용합니다.")
    @PostMapping("/sign-in")
    public AccountSignInResponse signIn(@RequestBody AccountSignInRequest request) {
        return accountSignInUseCase.signInByEmail(request);
    }

    @Operation(summary = "인증 코드 ", description = "회원 가입시 이메일로 인증코드를 발송합니다.")
    @GetMapping("/verify-code/{email}/{key}")
    public Boolean sendCode (
            @PathVariable String email,
            @PathVariable String key
    ) {
        return verifyEmaillUseCase.verifyEmail(email, key);
    }
}
