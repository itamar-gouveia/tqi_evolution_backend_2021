package com.tqi.loan.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ClientPutRequestBody {

    private Long id;

    private String name;

    private String email;

    private String cpf;

    private String rg;

    private String street;

    private Integer number;

    private String distric;

    private String city;

    private String zipCode;

    private String state;

    private BigDecimal income;

    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate registerDate;
}
