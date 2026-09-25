package com.loansphere.loanservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "LoanApplication")
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private String applicantName;

    private Long loanAmount;

    private Integer tenureMonths;

    private Double interestRate;

    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    private String employmentType;

    private Long monthlyIncome;

    private String purpose;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}