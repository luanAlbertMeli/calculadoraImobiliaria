package com.br.calculadoraimobiliaria.ultil;

import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.entities.Comodo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CasaUtil {

    public Casa criaCasa(String nomeBairro) {
        List<Comodo> comodos = new ArrayList<>();
        comodos.add(new Comodo("Sala", 12.6, 13));
        comodos.add(new Comodo("Banheiro", 8.0, 7));
        comodos.add(new Comodo("Cozinha", 8.0, 10));
        return new Casa("casaTest", "Rua tal", comodos, nomeBairro);
    }
}
