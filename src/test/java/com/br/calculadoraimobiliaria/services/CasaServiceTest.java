package com.br.calculadoraimobiliaria.services;


import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.ultil.CasaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
