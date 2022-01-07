package com.tqi.loan.service;

import com.tqi.loan.exception.BadRequestException;
import com.tqi.loan.models.Loan;

import com.tqi.loan.repository.LoanRepository;
import com.tqi.loan.requests.LoanPostRequestBody;
import com.tqi.loan.requests.LoanPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public Page<Loan> listAll(Pageable pageable){
        return loanRepository.findAll(pageable);
    }


    public Loan findById(long id){
        return loanRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("Loan not Found"));
    }


    public Loan save(LoanPostRequestBody loanPostRequestBody){
        Loan loan =  Loan.builder()
                .client(loanPostRequestBody.getClient())
                .requestDate(loanPostRequestBody.getRequestDate())
                .firstPaymentDate(loanPostRequestBody.getFirstPaymentDate())
                .qtdPayments(loanPostRequestBody.getQtdPayments())
                .amount(loanPostRequestBody.getAmount())
                .status(loanPostRequestBody.getStatus())
                .build();

        return loanRepository.save(loan);

    }

    public Loan update(LoanPutRequestBody loanPutRequestBody){
        Loan loan =  Loan.builder()
                .id(loanPutRequestBody.getId())
                .client(loanPutRequestBody.getClient())
                .requestDate(loanPutRequestBody.getRequestDate())
                .firstPaymentDate(loanPutRequestBody.getFirstPaymentDate())
                .qtdPayments(loanPutRequestBody.getQtdPayments())
                .amount(loanPutRequestBody.getAmount())
                .status(loanPutRequestBody.getStatus())
                .build();

        return loanRepository.save(loan);

    }

    public void delete(long id){
        loanRepository.delete(findById(id));
    }


}
