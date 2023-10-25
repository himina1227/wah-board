package com.example.wah.auth.aggregate.account.adapter.out.persistence.repository;

import com.example.wah.auth.aggregate.account.adapter.out.persistence.entity.AuthCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthCodeRepository extends JpaRepository<AuthCode, Long> {
    Optional<AuthCode> findByEmailAndCode(String email, String code);
}
