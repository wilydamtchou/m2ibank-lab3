package com.m2i.dto;

import java.time.LocalDateTime;

import com.m2i.model.AccountStatus;
import com.m2i.model.AccountType;

public record AccountDTO(
    Long accountId,
    Long clientId,
    AccountType type,
    double solde,
    LocalDateTime dateOuverture,
    AccountStatus statut
) {}
