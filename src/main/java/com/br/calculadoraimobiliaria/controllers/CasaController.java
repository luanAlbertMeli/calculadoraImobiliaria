package com.br.calculadoraimobiliaria.controllers;


import com.br.calculadoraimobiliaria.DTO.ComodoDTO;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.entities.Comodo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

import static com.br.calculadoraimobiliaria.services.CasaService.*;


@RestController
public class CasaController {


    @PostMapping("/area/nomeDaCasa")
    public double getMetrosQuadrados(@Valid @RequestBody Casa casa){
        return metroQuadrados(casa);
    }

    @PostMapping("/valor/nomeDaCasa")
    public BigDecimal getValorCasa(@Valid @RequestBody Casa casa){
        return valorCasa(casa);
    }

    @PostMapping("/maiorComodo/nomeDaCasa")
    public Comodo getMaiorComodo(@Valid @RequestBody Casa casa){
        return maiorComodo(casa);
    }

    @PostMapping("/areaComodos/nomeDaCasa")
    public List<ComodoDTO> getAreaComodos(@Valid @RequestBody Casa casa){
        return areaComodos(casa);
    }

}
