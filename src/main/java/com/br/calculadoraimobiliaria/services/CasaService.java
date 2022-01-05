package com.br.calculadoraimobiliaria.services;

import com.br.calculadoraimobiliaria.DTO.ComodoDTO;
import com.br.calculadoraimobiliaria.entities.Bairro;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.entities.Comodo;
import com.br.calculadoraimobiliaria.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CasaService {

    @Autowired
    BairroRepository bairroRepository;

    public static double metroQuadrados(Casa casa) {
        double metrosTotais = 0;

        for (Comodo cmd : casa.getComodos()) {
            metrosTotais += cmd.getComprimento() * cmd.getLargura();
        }
        return metrosTotais;
    }

    public BigDecimal valorCasa(Casa casa) {
        Bairro bairro = bairroRepository.buscaBairros(casa);

        return bairro.getValorRegiao().multiply(BigDecimal.valueOf(metroQuadrados(casa)));
    }

    public static Comodo maiorComodo(Casa casa) {
        double comodoMaior = 0;

        Comodo comodo = new Comodo();

        for (Comodo cmd : casa.getComodos()) {
            double m = cmd.getComprimento() * cmd.getLargura();
            if (m > comodoMaior) {
                comodo = cmd;
                comodoMaior = m;
            }
        }
        return comodo;
    }

    public static List<ComodoDTO> areaComodos(Casa casa) {
        List<ComodoDTO> comodoDTO = new ArrayList<>();
        for (Comodo cmd : casa.getComodos()) {
            comodoDTO.add(new ComodoDTO(cmd, cmd.getComprimento() * cmd.getLargura()));
        }
        return comodoDTO;
    }
}
