package com.br.calculadoraimobiliaria.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bairro {

    @NotNull(message = "Que o valor do metro quadrado no bairro não pode estar branco.")
    @NotEmpty(message = "Que o valor do metro quadrado no bairro não pode estar vazio.")
    @Size(max = 13, message = "O comprimento do bairro não pode exceder 13 dígitos")
    private BigDecimal valorRegiao;
    @NotNull(message = "Nome do bairro não deve está em branco")
    @NotEmpty(message = "O nome do bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres")
    private String nome;
}
