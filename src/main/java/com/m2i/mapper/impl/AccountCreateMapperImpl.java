package com.m2i.mapper.impl;

import com.m2i.dto.AccountCreateDTO;
import com.m2i.entity.Account;
import com.m2i.mapper.AccountCreateMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountCreateMapperImpl implements AccountCreateMapper {

    @Override
    public Account toEntity(AccountCreateDTO dto) {
        Account account = new Account();
        account.setType(dto.type());
        account.setSolde(0.0);
        return account;
    }

    @Override
    public AccountCreateDTO toDto(Account entity) {
        return new AccountCreateDTO(
            entity.getClient().getClientId(),
            entity.getType()
        );
    }
}
