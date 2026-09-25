package com.loansphere.loanservice.service;

import com.loansphere.loanservice.dto.LoanApplicationRequestDTO;

import java.util.List;

public interface LoanApplicationService {

    public LoanApplicationRequestDTO createLoanApplication(LoanApplicationRequestDTO requestDTO);

    public LoanApplicationRequestDTO getLoanApplicationById(Long id);

    public List<LoanApplicationRequestDTO> getAllLoanApplications();

    public LoanApplicationRequestDTO updateLoanApplication(Long id, LoanApplicationRequestDTO dto);

    public void deleteLoanApplication(Long id);
}
