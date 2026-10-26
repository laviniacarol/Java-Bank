package com.laviniacarol.javabank.dto;

import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String name,
        String cpf,
        String email,
        LocalDateTime createdAt
) {
}