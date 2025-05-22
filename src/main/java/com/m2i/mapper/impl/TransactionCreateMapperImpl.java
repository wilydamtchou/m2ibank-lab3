package com.m2i.mapper.impl;

import com.m2i.dto.TransactionCreateDTO;
import com.m2i.entity.Transaction;
import com.m2i.mapper.TransactionCreateMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionCreateMapperImpl implements TransactionCreateMapper {

    @Override
    public Transaction toEntity(TransactionCreateDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setMontant(dto.montant());
        transaction.setType(dto.type());
        return transaction;
    }

    @Override
    public TransactionCreateDTO toDto(Transaction entity) {
        return new TransactionCreateDTO(
            entity.getSourceAccount().getAccountId(),
            entity.getTargetAccount().getAccountId(),
            entity.getMontant(),
            entity.getType()
        );
    }
}
