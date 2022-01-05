package com.br.calculadoraimobiliaria.repository;

import com.br.calculadoraimobiliaria.entities.Bairro;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BairroRepository {

    public List<Bairro> criaListaDeBairros() {
        List<Bairro> bairrosCadastrados = new ArrayList<>();
        bairrosCadastrados.add(new Bairro(new BigDecimal(800.00), "Niteroi"));
        bairrosCadastrados.add(new Bairro(new BigDecimal(900.00), "Inga"));
        bairrosCadastrados.add(new Bairro(new BigDecimal(1000.00), "Copacabana"));
        bairrosCadastrados.add(new Bairro(new BigDecimal(1500.00), "Ipanema"));

        return bairrosCadastrados;
    }

    public Bairro buscaBairros(Casa casa) {
        return criaListaDeBairros()
                .stream()
                .filter(bairro -> bairro.getNome().equalsIgnoreCase(casa.getNomeBairro())).findFirst().orElseThrow(() -> new RepositoryException("Bairro não encontrado na base de dados."));
    }
}
