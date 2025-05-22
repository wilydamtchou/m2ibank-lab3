package com.m2i.dto;

import com.m2i.model.TransactionType;

public record TransactionCreateDTO(
    Long sourceAccountId,
    Long targetAccountId,
    double montant,
    TransactionType type
) {}

