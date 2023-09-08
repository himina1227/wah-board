package com.example.wah.auth.aggregate.account.adapter.in.rest;

import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignUpRequest;
import com.example.wah.auth.aggregate.account.application.service.AccountService;
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
@RequestMapping("/account")
public class AccountController {
    private final AccountService service;

    @Operation(summary = "user 등록", description = "user 신규 등록합니다.")
    @PostMapping("/sign-up")
    public void signUp(@RequestBody AccountSignUpRequest request) {
        service.signUp(request);
    }
    @Operation(summary = "user 로그인", description = "user 로그인시 사용합니다.")
    @PostMapping("/sign-in")
    public void signIn() {

    }
}
