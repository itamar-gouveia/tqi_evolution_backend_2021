package com.tqi.loan.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ClientPostRequestBody {

    @NotEmpty(message="The field name connot be empty")
    @NotNull(message="The field name connot be null")
    private String name;

    @NotEmpty(message="The field name connot be empty")
    @NotNull(message="The field name connot be null")
    @Email(message = "this email is not valid")
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
