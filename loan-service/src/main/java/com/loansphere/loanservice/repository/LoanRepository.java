package com.loansphere.loanservice.repository;

import com.loansphere.loanservice.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanApplication, Long> {
}
