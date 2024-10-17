package org.donjuan.springreactive.controller;

import org.donjuan.springreactive.model.FinancialTransaction;
import org.donjuan.springreactive.service.FinancialTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/transactions")
public class FinancialTransactionController {

    @Autowired
    private FinancialTransactionService service;

    @PostMapping
    public Mono<FinancialTransaction> createTransaction(@RequestBody FinancialTransaction transaction) {
        return service.saveTransaction(transaction);
    }


    /** call http://localhost:8080/api/transactions */
    @GetMapping
    public Flux<FinancialTransaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Mono<FinancialTransaction> getTransactionById(@PathVariable String id) {
        return service.getTransactionById(id);
    }

    @GetMapping("/total")
    public Mono<BigDecimal> getTotalAmount() {
        return service.calculateTotalAmount();
    }
}