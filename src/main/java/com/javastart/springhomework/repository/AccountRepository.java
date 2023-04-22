package com.javastart.springhomework.repository;

import com.javastart.springhomework.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
