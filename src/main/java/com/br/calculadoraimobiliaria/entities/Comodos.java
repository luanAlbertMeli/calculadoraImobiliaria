package com.br.calculadoraimobiliaria.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data //Setar getters e setters
@AllArgsConstructor //gera o construtor cheio com todos argumentos
@NoArgsConstructor
public class Comodos {

    @NotNull(message = "O campo não pode estar branco.")
    @NotEmpty(message = "O campo não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do cômodo não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String nome;
    @NotNull(message = "A largura do cômodo não pode estar em branco")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private double largura;
    @NotNull(message = "O comprimento do cômodo não pode estar em branco")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros")
    private double comprimento;

}
