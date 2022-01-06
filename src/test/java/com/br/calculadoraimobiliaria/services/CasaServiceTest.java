package com.br.calculadoraimobiliaria.services;


import com.br.calculadoraimobiliaria.DTO.ComodoDTO;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.entities.Comodo;
import com.br.calculadoraimobiliaria.util.CasaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

@SpringBootTest
public class CasaServiceTest {

    @Autowired
    private CasaService casaService;
    @Autowired
    private CasaUtil casaUtil;

    @Test
    void deveCalcularOsMetrosQuadradosDaCasa() {
        Casa casa = casaUtil.criaCasa("Ipanema");

        double metroQuadradosEsperado = casa.getComodos()
                .stream()
                .map(comodo -> comodo.getComprimento() * comodo.getLargura())
                .reduce(0.0, Double::sum);

        double metroQuadrados = casaService.metroQuadrados(casa);

        Assertions.assertEquals(metroQuadradosEsperado, metroQuadrados);

    }

    @Test
    void deveRetornarMaiorComodo( ){
        Casa casa = casaUtil.criaCasa("Ipanema");
        Comodo comodo = casaService.maiorComodo(casa);

        Assertions.assertEquals("Sala", comodo.getNome());
    }

    @Test
    void deveRetornarCalculoPorComodo( ){
        Casa casa = casaUtil.criaCasa("Jd. Pizza");
        List<ComodoDTO> comodoTamanhoList = casaService.areaComodos(casa);

        Assertions.assertEquals(156, comodoTamanhoList.get(0).getMetrosQuadrados());
        Assertions.assertEquals(56, comodoTamanhoList.get(1).getMetrosQuadrados());
        Assertions.assertEquals(80, comodoTamanhoList.get(2).getMetrosQuadrados());
    }

    @Test
    void deveRetornarValorCasa( ){
        Casa casa = casaUtil.criaCasa("Niteroi");
        BigDecimal valorCasa = casaService.valorCasa(casa);
        Assertions.assertEquals(new BigDecimal("233600.000"), valorCasa);
    }

}
