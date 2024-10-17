package org.donjuan.springreactive.model;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FinancialTransactionRepository extends R2dbcRepository<FinancialTransaction, Long> {
    Mono<FinancialTransaction> findByAccountId(String id);

    @Override
    Flux<FinancialTransaction> findAll();
}