package com.br.calculadoraimobiliaria.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bairro {

    @NotNull(message = "Que o valor do metro quadrado no bairro não pode estar branco.")
    @Digits(integer = 13, fraction = 2, message = "O comprimento do bairro não pode exceder 13 dígitos")
    private BigDecimal valorRegiao;
    @NotNull(message = "Nome do bairro não deve está em branco")
    @NotEmpty(message = "O nome do bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres")
    private String nome;
}
