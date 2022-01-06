package com.br.calculadoraimobiliaria.DTO;

import com.br.calculadoraimobiliaria.entities.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComodoDTO {
    private Comodo comodo;
    private Double metrosQuadrados;
}
