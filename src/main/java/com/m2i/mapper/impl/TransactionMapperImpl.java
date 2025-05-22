package com.m2i.mapper.impl;

import com.m2i.dto.TransactionDTO;
import com.m2i.entity.Transaction;
import com.m2i.mapper.TransactionMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toEntity(TransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(dto.transactionId());
        transaction.setMontant(dto.montant());
        transaction.setDateHeure(dto.dateHeure());
        transaction.setType(dto.type());
        transaction.setStatut(dto.statut());
        return transaction;
    }

    @Override
    public TransactionDTO toDto(Transaction entity) {
        return new TransactionDTO(
            entity.getTransactionId(),
            entity.getSourceAccount().getAccountId(),
            entity.getTargetAccount().getAccountId(),
            entity.getMontant(),
            entity.getDateHeure(),
            entity.getType(),
            entity.getStatut()
        );
    }
}
