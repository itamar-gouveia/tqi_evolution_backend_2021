package com.tqi.loan.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LoanPutRequestBody {

    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate requestDate ;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate firstPaymentDate;


    private BigDecimal amount;


    private Integer qtdPayments;

    private Long client;  //id do cliente

    private String status = "P";   //A = Aprovado   P = Pendente   R = Recusado
}