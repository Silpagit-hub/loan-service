package com.loansphere.loanservice.controller;

import com.loansphere.loanservice.dto.LoanApplicationRequestDTO;
import com.loansphere.loanservice.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanApplicationController {
    @Autowired
    LoanApplicationService loanApplicationService;

@PostMapping("/createLoan")
   public ResponseEntity<LoanApplicationRequestDTO> createLoan(@RequestBody LoanApplicationRequestDTO loanDto){
       return new ResponseEntity<>(loanApplicationService.createLoanApplication(loanDto), HttpStatus.OK);
   }
}
