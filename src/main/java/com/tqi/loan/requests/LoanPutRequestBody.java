package com.tqi.loan.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Range(min=1 , max =60, message = "Parcels cannot be greater than 60")
    private Integer qtdPayments;

    private Long client;  //id do cliente

    private String status = "P";   //A = Aprovado   P = Pendente   R = Recusado
}
