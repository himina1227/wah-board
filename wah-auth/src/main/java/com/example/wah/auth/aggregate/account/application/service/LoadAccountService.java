package com.example.wah.auth.aggregate.account.application.service;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.Account;
import com.example.wah.auth.aggregate.account.application.port.in.LoadAccountUseCase;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInRequest;
import com.example.wah.auth.aggregate.account.application.port.in.data.AccountSignInResponse;
import com.example.wah.auth.aggregate.account.application.port.out.LoadAccountPort;
import com.example.wah.auth.jwt.JwtTokenProvider;
import com.example.wah.auth.util.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class LoadAccountService implements LoadAccountUseCase {
    private final LoadAccountPort loadAccountPort;
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public AccountSignInResponse signInByEmail(AccountSignInRequest request) {

        Account account = loadAccountPort.loadAccount(request);

        UserDetails userDetails = PrincipalDetails
                .builder()
                .email(account.getEmail())
                .role(account.getAuthorities().toString())
                .build();

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return AccountSignInResponse.of(jwtTokenProvider.createToken(authentication));
    }
}
