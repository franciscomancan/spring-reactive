package org.donjuan.springreactive.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FinancialTransaction {
    private Long id;
    private String accountId;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    private String description;
    private LocalDateTime timestamp;

    // Constructor, getters, and setters
    public FinancialTransaction(Long id, String accountId, BigDecimal amount, String description, LocalDateTime timestamp) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
    }

    // Getters and setters omitted for brevity
}