package com.br.calculadoraimobiliaria.controllers;


import com.br.calculadoraimobiliaria.DTO.ComodoDTO;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.entities.Comodos;
import com.br.calculadoraimobiliaria.services.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.br.calculadoraimobiliaria.services.CasaService.*;


@RestController
public class CasaController {


    @PostMapping("/area/nomeDaCasa")
    public double getMetrosQuadrados(@RequestBody Casa casa){
        return metroQuadrados(casa);
    }

    @PostMapping("/valor/nomeDaCasa")
    public double getValorCasa(@RequestBody Casa casa){
        return valorCasa(casa);
    }

    @PostMapping("/maiorComodo/nomeDaCasa")
    public Comodos getMaiorComodo(@RequestBody Casa casa){
        return maiorComodo(casa);
    }

    @PostMapping("/areaComodos/nomeDaCasa")
    public List<ComodoDTO> getAreaComodos(@RequestBody Casa casa){
        return areaComodos(casa);
    }

}
