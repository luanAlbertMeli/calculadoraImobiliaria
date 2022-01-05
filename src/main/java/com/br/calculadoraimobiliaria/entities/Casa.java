package com.br.calculadoraimobiliaria.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Casa {

    @NotNull (message = "Nome do imóvel não deve está em branco")
    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z].*", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String nome;
    private String endereco;
    @Valid
    private List<Comodos> comodos;
    @Valid
    private Bairro bairro;
}
