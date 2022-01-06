package com.br.calculadoraimobiliaria.controllers;


import com.br.calculadoraimobiliaria.DTO.ComodoDTO;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.entities.Comodo;
import com.br.calculadoraimobiliaria.services.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

import static com.br.calculadoraimobiliaria.services.CasaService.*;


@RestController
public class CasaController {

    @Autowired
    CasaService casaService;

    @PostMapping("/area/nomeDaCasa")
    public ResponseEntity<Double> getMetrosQuadrados(@Valid @RequestBody Casa casa) {
        return ResponseEntity.ok().body(metroQuadrados(casa));
    }

    @PostMapping("/valor/nomeDaCasa")
    public ResponseEntity<BigDecimal> getValorCasa(@Valid @RequestBody Casa casa) {
        return ResponseEntity.ok().body(casaService.valorCasa(casa));
    }

    @PostMapping("/maiorComodo/nomeDaCasa")
    public ResponseEntity<Comodo> getMaiorComodo(@Valid @RequestBody Casa casa) {
        return ResponseEntity.ok().body(maiorComodo(casa));
    }

    @PostMapping("/areaComodos/nomeDaCasa")
    public ResponseEntity<List<ComodoDTO>> getAreaComodos(@Valid @RequestBody Casa casa) {
        return ResponseEntity.ok().body(areaComodos(casa));
    }
}
