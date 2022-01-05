package com.br.calculadoraimobiliaria.services;


import com.br.calculadoraimobiliaria.entities.Bairro;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.entities.Comodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CasaServiceTest {

    @Autowired
    CasaService casaService;

    private Casa criaCasa() {
        Bairro bairro = new Bairro(new BigDecimal(123), "Jd. Pizza");
        List<Comodo> comodos = new ArrayList<>();
        comodos.add(new Comodo("Sala", 12.6, 13));
        comodos.add(new Comodo("Banheiro", 8.0, 7));
        comodos.add(new Comodo("Cozinha", 8.0, 10));
        return new Casa("casaTest", "Rua tal", comodos, "Jd. Pizza");
    }

    @Test
    void deveCalcularOsMetrosQuadradosDaCasa() {
        Casa casa = criaCasa();

        double metroQuadradosEsperado = casa.getComodos()
                .stream()
                .map(comodo -> comodo.getComprimento() * comodo.getLargura())
                .reduce(0.0, Double::sum);

        double metroQuadrados = casaService.metroQuadrados(casa);

        Assertions.assertEquals(metroQuadradosEsperado, metroQuadrados);

    }

}
