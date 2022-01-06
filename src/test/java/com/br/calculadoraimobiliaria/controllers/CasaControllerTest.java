package com.br.calculadoraimobiliaria.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CasaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String payLoadValido =
            "{\n" +
                    "    \"nome\": \"CasaBraba\",\n" +
                    "    \"endereco\": \"Rua Meli\",\n" +
                    "    \"comodos\": [\n" +
                    "        {\n" +
                    "            \"nome\": \"Sala\",\n" +
                    "            \"largura\": 25,\n" +
                    "            \"comprimento\": 25\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"nome\": \"Quarto\",\n" +
                    "            \"largura\": 3.0,\n" +
                    "            \"comprimento\": 3.0\n" +
                    "        }\n" +
                    "    ],\n" +
                    "    \"nomeBairro\": \"Ipanema\"\n" +
                    "}";

    private final String payLoadInvalido =
            "{\n" +
                    "    \"nome\": \"CasaBraba\",\n" +
                    "    \"endereco\": \"Rua Meli\",\n" +
                    "    \"comodos\": [\n" +
                    "        {\n" +
                    "            \"nome\": \"Sala\",\n" +
                    "            \"largura\": 25,\n" +
                    "            \"comprimento\": 25\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"nome\": \"Quarto\",\n" +
                    "            \"largura\": 3.0,\n" +
                    "            \"comprimento\": 3.0\n" +
                    "        }\n" +
                    "    ],\n" +
                    "}";

    @Test
    public void getMetrosQuadradosDeveRetornarMetrosQuadradosDaCasaQuandoCasaValida() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/area/nomeDaCasa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoadValido))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getMetrosQuadradosDeveRetornarBadRequestQuandoCasaInvalida() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/area/nomeDaCasa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoadInvalido))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getValorCasaDeveRetornarValorDaCasaQuandoCasaValida() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/valor/nomeDaCasa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoadValido))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getValorCasaDeveRetornarBadRequestQuandoCasaInvalida() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/valor/nomeDaCasa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoadInvalido))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getMaiorComodoDeveRetornarMaiorComodoDaCasaQuandoCasaValida() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/maiorComodo/nomeDaCasa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoadValido))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getMaiorComodoDeveRetornarBadRequestQuandoCasaInvalida() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/maiorComodo/nomeDaCasa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoadInvalido))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void getAreaComodosDeveRetornarAreaDosComodosQuandoCasaValida() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/areaComodos/nomeDaCasa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoadValido))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAreaComodosDeveRetornarBadRequestQuandoCasaInvalida() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/areaComodos/nomeDaCasa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payLoadInvalido))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();
    }
}