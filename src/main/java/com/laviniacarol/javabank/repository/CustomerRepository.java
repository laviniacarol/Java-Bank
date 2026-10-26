package com.laviniacarol.javabank.repository;

import com.laviniacarol.javabank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);
}