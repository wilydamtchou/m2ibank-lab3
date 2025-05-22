package com.m2i.dto;

import java.time.LocalDateTime;

import com.m2i.model.TransactionStatus;
import com.m2i.model.TransactionType;

public record TransactionDTO(
    Long transactionId,
    Long sourceAccountId,
    Long targetAccountId,
    double montant,
    LocalDateTime dateHeure,
    TransactionType type,
    TransactionStatus statut
) {}

