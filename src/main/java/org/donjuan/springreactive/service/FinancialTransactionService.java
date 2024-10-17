package org.donjuan.springreactive.service;


import org.donjuan.springreactive.model.FinancialTransaction;
import org.donjuan.springreactive.model.FinancialTransactionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*
Doesn't work at this point because table doesn't exist.

CREATE TABLE IF NOT EXISTS financial_transaction (
    id SERIAL PRIMARY KEY,
    accountId TEXT NOT NULL,
    amount NUMERIC,
    description TEXT,
    timestamp TIMESTAMP WITH TIME ZONE
);

        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;

 */
@Service
public class FinancialTransactionService {
    private final Map<Long, FinancialTransaction> transactionStore = new ConcurrentHashMap<Long, FinancialTransaction>();

    private final FinancialTransactionRepository trxRepo;

    public FinancialTransactionService(FinancialTransactionRepository trxRepo) {
        this.trxRepo = trxRepo;
    }

    public Mono<FinancialTransaction> saveTransaction(FinancialTransaction transaction) {
        return Mono.just(transaction)
                .map(t -> {
                    transactionStore.put(t.getId(), t);
                    return t;
                });
    }

    public Flux<FinancialTransaction> getAllTransactions() {
        return trxRepo.findAll();
    }

    public Mono<FinancialTransaction> getTransactionById(String id) {
        return Mono.justOrEmpty(transactionStore.get(id));
    }

    public Mono<BigDecimal> calculateTotalAmount() {
        return getAllTransactions()
                .map(FinancialTransaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}