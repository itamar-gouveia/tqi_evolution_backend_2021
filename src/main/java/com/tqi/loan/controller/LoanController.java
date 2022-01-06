package com.tqi.loan.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.tqi.loan.models.Loan;
import com.tqi.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tqi.loan.models.Client;
import com.tqi.loan.repository.ClientRepository;

@RestController
@RequestMapping(value="/loans")
public class LoanController {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    ClientRepository customerRepository;


    @GetMapping("/todos")
    public List<Loan> listLoans(){

        return loanRepository.findAll();
    }

    @GetMapping("/{id}")
    public Loan listLoanId(@PathVariable  Long id) {
        return loanRepository.findById(id).get();
    }

    @PostMapping("/new/{id}")
    public String saveLoan(@PathVariable Long id , @RequestBody Loan loan) {

        return "jflafjd";
    }

    @PutMapping("/aprprove")
    public Loan approveLoan(@RequestBody Loan loan) {

            return loanRepository.save(loan);



    }

    @PutMapping("/update")
    public Loan atualizarEmprestimo(@RequestBody Loan loan){
        return loanRepository.save(loan);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        loanRepository.deleteById(id);

    }


}
