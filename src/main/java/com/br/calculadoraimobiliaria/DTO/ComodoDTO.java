package com.br.calculadoraimobiliaria.DTO;

import com.br.calculadoraimobiliaria.entities.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Setar getters e setters
@AllArgsConstructor //gera o construtor cheio com todos argumentos
@NoArgsConstructor
public class ComodoDTO {
    private Comodo comodo;
    private Double metrosQuadrados;
}
