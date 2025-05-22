package com.m2i.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.m2i.model.AccountStatus;
import com.m2i.model.AccountType;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    
    private Long clientId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private AccountType type;
    private double solde;
    private LocalDateTime dateOuverture;
    private AccountStatus statut;

    @OneToMany(mappedBy = "sourceAccount", cascade = CascadeType.ALL)
    private List<Transaction> transactionsSource;

    @OneToMany(mappedBy = "targetAccount", cascade = CascadeType.ALL)
    private List<Transaction> transactionsTarget;

	/**
	 * 
	 */
	public Account() {
		super();

		statut = AccountStatus.OPENED;
		dateOuverture = LocalDateTime.now();
	}

	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the type
	 */
	public AccountType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(AccountType type) {
		this.type = type;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the dateOuverture
	 */
	public LocalDateTime getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * @param dateOuverture the dateOuverture to set
	 */
	public void setDateOuverture(LocalDateTime dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	/**
	 * @return the statut
	 */
	public AccountStatus getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(AccountStatus statut) {
		this.statut = statut;
	}

	/**
	 * @return the transactionsSource
	 */
	public List<Transaction> getTransactionsSource() {
		return transactionsSource;
	}

	/**
	 * @param transactionsSource the transactionsSource to set
	 */
	public void setTransactionsSource(List<Transaction> transactionsSource) {
		this.transactionsSource = transactionsSource;
	}

	/**
	 * @return the transactionsTarget
	 */
	public List<Transaction> getTransactionsTarget() {
		return transactionsTarget;
	}

	/**
	 * @param transactionsTarget the transactionsTarget to set
	 */
	public void setTransactionsTarget(List<Transaction> transactionsTarget) {
		this.transactionsTarget = transactionsTarget;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", client=" + client + ", type=" + type + ", solde=" + solde
				+ ", dateOuverture=" + dateOuverture + ", statut=" + statut + ", transactionsSource="
				+ transactionsSource + ", transactionsTarget=" + transactionsTarget + "]";
	}
}

