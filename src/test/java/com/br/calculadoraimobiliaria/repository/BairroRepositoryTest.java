package com.br.calculadoraimobiliaria.repository;

import com.br.calculadoraimobiliaria.entities.Bairro;
import com.br.calculadoraimobiliaria.entities.Casa;
import com.br.calculadoraimobiliaria.exception.RepositoryException;
import com.br.calculadoraimobiliaria.util.CasaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BairroRepositoryTest {

    @Autowired
    private CasaUtil casaUtil;
    @Autowired
    private BairroRepository bairroRepository;

    @Test
    void deveriaBuscarBairros() {
        Casa casa = casaUtil.criaCasa("Ipanema");
        Bairro bairroEsperado = new Bairro(new BigDecimal(800), "Ipanema");
        Bairro result = bairroRepository.buscaBairros(casa);

        Assertions.assertEquals(bairroEsperado.getNome(), result.getNome());
    }

    @Test
    void deveriaRetornarRepositoryExceptionQuandoBairroNaoExiste() {
        Casa casa = casaUtil.criaCasa("Jd pizza");
        RepositoryException repositoryException = assertThrows(RepositoryException.class, () -> bairroRepository.buscaBairros(casa));

        Assertions.assertTrue(repositoryException.getMessage().contains("Bairro não encontrado na base de dados."));

    }

    @Test
    void deveriaRetornarUmRepositoryExceptionQuandoCasaForInstanciadaVazia() {
        Casa casa = new Casa();
        assertThrows(RepositoryException.class, () -> bairroRepository.buscaBairros(casa));

    }
}
