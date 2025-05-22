package com.m2i.dto;

import com.m2i.model.AccountType;

public record AccountCreateDTO(
    Long clientId,
    AccountType type
) {}

