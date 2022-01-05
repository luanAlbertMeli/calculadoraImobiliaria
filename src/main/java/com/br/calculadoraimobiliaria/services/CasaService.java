package com.br.calculadoraimobiliaria.services;

import com.br.calculadoraimobiliaria.DTO.ComodoDTO;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.entities.Comodo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CasaService {
    public static double metroQuadrados(Casa casa) {
        double metrosTotais = 0;

        for (Comodo cmd : casa.getComodos()) {
            metrosTotais += cmd.getComprimento() * cmd.getLargura();
        }
        return metrosTotais;
    }

    public static BigDecimal valorCasa(Casa casa) {
        return casa.getBairro().getValorRegiao().multiply(BigDecimal.valueOf(metroQuadrados(casa)));
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
