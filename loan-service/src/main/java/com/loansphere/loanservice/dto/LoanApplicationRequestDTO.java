package com.loansphere.loanservice.dto;

import com.loansphere.loanservice.entity.LoanType;
import lombok.Data;

@Data
public class LoanApplicationRequestDTO {

    private Long customerId;
    private String applicantName;
    private Long loanAmount;
    private Integer tenureMonths;
    private Double interestRate;
    private LoanType loanType;
    private String employmentType;
    private Long monthlyIncome;
    private String purpose;
}
