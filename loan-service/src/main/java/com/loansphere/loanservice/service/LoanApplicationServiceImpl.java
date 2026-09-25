package com.loansphere.loanservice.service;

import com.loansphere.loanservice.dto.LoanApplicationRequestDTO;
import com.loansphere.loanservice.entity.LoanApplication;
import com.loansphere.loanservice.entity.LoanStatus;
import com.loansphere.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public LoanApplicationRequestDTO createLoanApplication(LoanApplicationRequestDTO requestDTO) {
        LoanApplication loanApplication =
                objectMapper.convertValue(requestDTO, LoanApplication.class);

        loanApplication.setStatus(LoanStatus.UNDER_REVIEW);
        loanApplication.setCreatedAt(LocalDateTime.now());
        loanApplication.setUpdatedAt(LocalDateTime.now());

        loanApplication  = loanRepository.save(loanApplication);

       return requestDTO = objectMapper.convertValue(loanApplication, LoanApplicationRequestDTO.class);
    }

    @Override
    public LoanApplicationRequestDTO getLoanApplicationById(Long id){

        LoanApplication loanApplication= loanRepository.findById(id).orElseThrow(()->new RuntimeException("Loan application is not available"));

        LoanApplicationRequestDTO loanDto= new LoanApplicationRequestDTO();

        loanDto.setCustomerId(loanApplication.getCustomerId());
        loanDto.setApplicantName(loanApplication.getApplicantName());
        loanDto.setLoanAmount(loanApplication.getLoanAmount());
        loanDto.setTenureMonths(loanApplication.getTenureMonths());
        loanDto.setInterestRate(loanApplication.getInterestRate());
        loanDto.setLoanType(loanApplication.getLoanType());
        loanDto.setEmploymentType(loanApplication.getEmploymentType());
        loanDto.setMonthlyIncome(loanApplication.getMonthlyIncome());
        loanDto.setPurpose(loanApplication.getPurpose());

        return loanDto;
    }

    @Override
    public List<LoanApplicationRequestDTO> getAllLoanApplications() {
        List<LoanApplication> loanApplication= loanRepository.findAll();

        List<LoanApplicationRequestDTO> dtoList = new ArrayList<>();

        for (LoanApplication loanApplications : loanApplication) {

            LoanApplicationRequestDTO loanDto = new LoanApplicationRequestDTO();

            loanDto.setCustomerId(loanApplications.getCustomerId());
            loanDto.setApplicantName(loanApplications.getApplicantName());
            loanDto.setLoanAmount(loanApplications.getLoanAmount());
            loanDto.setTenureMonths(loanApplications.getTenureMonths());
            loanDto.setInterestRate(loanApplications.getInterestRate());
            loanDto.setLoanType(loanApplications.getLoanType());
            loanDto.setEmploymentType(loanApplications.getEmploymentType());
            loanDto.setMonthlyIncome(loanApplications.getMonthlyIncome());
            loanDto.setPurpose(loanApplications.getPurpose());

            dtoList.add(loanDto);
        }
        return dtoList;
    }

    @Override
    public LoanApplicationRequestDTO updateLoanApplication(Long id, LoanApplicationRequestDTO dto) {

        LoanApplication loanApplication =
                loanRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Loan application not found"));
        loanApplication.setCustomerId(dto.getCustomerId());
        loanApplication.setApplicantName(dto.getApplicantName());
        loanApplication.setLoanAmount(dto.getLoanAmount());
        loanApplication.setTenureMonths(dto.getTenureMonths());
        loanApplication.setInterestRate(dto.getInterestRate());
        loanApplication.setLoanType(dto.getLoanType());
        loanApplication.setEmploymentType(dto.getEmploymentType());
        loanApplication.setMonthlyIncome(dto.getMonthlyIncome());
        loanApplication.setPurpose(dto.getPurpose());

        loanApplication.setUpdatedAt(LocalDateTime.now());

        LoanApplication updatedLoan =
                loanRepository.save(loanApplication);

        LoanApplicationRequestDTO response = new LoanApplicationRequestDTO();

        response.setCustomerId(updatedLoan.getCustomerId());
        response.setApplicantName(updatedLoan.getApplicantName());
        response.setLoanAmount(updatedLoan.getLoanAmount());
        response.setTenureMonths(updatedLoan.getTenureMonths());
        response.setInterestRate(updatedLoan.getInterestRate());
        response.setLoanType(updatedLoan.getLoanType());
        response.setEmploymentType(updatedLoan.getEmploymentType());
        response.setMonthlyIncome(updatedLoan.getMonthlyIncome());
        response.setPurpose(updatedLoan.getPurpose());

        return response;
    }

    @Override
    public void deleteLoanApplication(Long id) {

        LoanApplication loanApplication = loanRepository.findById(id).orElseThrow(()->new RuntimeException("The application not found"));

        loanRepository.delete(loanApplication);
    }
}
