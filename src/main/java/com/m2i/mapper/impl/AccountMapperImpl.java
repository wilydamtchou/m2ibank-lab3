package com.m2i.mapper.impl;

import com.m2i.dto.AccountDTO;
import com.m2i.entity.Account;
import com.m2i.mapper.AccountMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toEntity(AccountDTO dto) {
        Account account = new Account();
        account.setAccountId(dto.accountId());
        account.setType(dto.type());
        account.setSolde(dto.solde());
        account.setDateOuverture(dto.dateOuverture());
        account.setStatut(dto.statut());
        return account;
    }

    @Override
    public AccountDTO toDto(Account entity) {
        return new AccountDTO(
            entity.getAccountId(),
            entity.getClient().getClientId(),
            entity.getType(),
            entity.getSolde(),
            entity.getDateOuverture(),
            entity.getStatut()
        );
    }
}
