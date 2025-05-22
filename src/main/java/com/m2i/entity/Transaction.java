package com.m2i.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.m2i.model.TransactionStatus;
import com.m2i.model.TransactionType;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "account_src")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "account_tgt")
    private Account targetAccount;

    private double montant;
    private LocalDateTime dateHeure;
    private TransactionType type;
    private TransactionStatus statut;
    
    
	/**
	 * 
	 */
	public Transaction() {
		super();
		
		dateHeure = LocalDateTime.now();
		statut = TransactionStatus.PENDING;
	}

	/**
	 * @return the transactionId
	 */
	public Long getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the sourceAccount
	 */
	public Account getSourceAccount() {
		return sourceAccount;
	}
	/**
	 * @param sourceAccount the sourceAccount to set
	 */
	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	/**
	 * @return the targetAccount
	 */
	public Account getTargetAccount() {
		return targetAccount;
	}
	/**
	 * @param targetAccount the targetAccount to set
	 */
	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}
	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	/**
	 * @return the dateHeure
	 */
	public LocalDateTime getDateHeure() {
		return dateHeure;
	}
	/**
	 * @param dateHeure the dateHeure to set
	 */
	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}
	/**
	 * @return the type
	 */
	public TransactionType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TransactionType type) {
		this.type = type;
	}
	/**
	 * @return the statut
	 */
	public TransactionStatus getStatut() {
		return statut;
	}
	/**
	 * @param statut the statut to set
	 */
	public void setStatut(TransactionStatus statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", sourceAccount=" + sourceAccount + ", targetAccount="
				+ targetAccount + ", montant=" + montant + ", dateHeure=" + dateHeure + ", type=" + type + ", statut="
				+ statut + "]";
	}
}
