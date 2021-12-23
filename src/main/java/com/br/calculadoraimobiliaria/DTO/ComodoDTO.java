package com.br.calculadoraimobiliaria.DTO;

import com.br.calculadoraimobiliaria.entities.Comodos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Setar getters e setters
@AllArgsConstructor //gera o construtor cheio com todos argumentos
@NoArgsConstructor
public class ComodoDTO {
    private Comodos comodos;
    private Double metrosQuadrados;
}
