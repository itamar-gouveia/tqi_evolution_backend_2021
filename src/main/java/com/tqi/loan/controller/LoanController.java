package com.tqi.loan.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.tqi.loan.models.Loan;
import com.tqi.loan.repository.LoanRepository;
import com.tqi.loan.requests.ClientPostRequestBody;
import com.tqi.loan.requests.ClientPutRequestBody;
import com.tqi.loan.requests.LoanPostRequestBody;
import com.tqi.loan.requests.LoanPutRequestBody;
import com.tqi.loan.service.ClientService;
import com.tqi.loan.service.LoanService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import javax.validation.Valid;

@RestController
@RequestMapping(value="/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @GetMapping(path = "/all")
    @ApiOperation(value = "List all Loans")
    public ResponseEntity<Page<Loan>> list(Pageable pageable){
        return ResponseEntity.ok(loanService.listAll(pageable));
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Find loan by Id")
    public ResponseEntity<Loan> findById(@PathVariable long id){
        return ResponseEntity.ok(loanService.findById(id));
    }

    @PostMapping(path = "/new")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value="Save new loan")
    public ResponseEntity<Loan> save(@RequestBody @Valid LoanPostRequestBody loanPostRequestBody){
        return  new ResponseEntity<>(loanService.save(loanPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value="Update existing Client")
    public ResponseEntity<Void> update(@RequestBody LoanPutRequestBody loanPutRequestBody){
        loanService.update(loanPutRequestBody);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value="Delete existing loan")
    public ResponseEntity<Void> delete(@PathVariable long id){
        loanService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
