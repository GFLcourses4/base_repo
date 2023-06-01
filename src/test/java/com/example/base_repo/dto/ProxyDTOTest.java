package com.example.base_repo.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


class ProxyDTOTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void writeJson() throws JsonProcessingException {
        CredsDTO credsDTO = new CredsDTO("Username", "password");
        ProxyDTO proxyDTO = new ProxyDTO("localhost", 8080, credsDTO);
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(proxyDTO);
        System.out.println(value);
    }

    @Test
    public void readJson() throws IOException, URISyntaxException {
        URI uri = this.getClass().getClassLoader().getResource("proxy.json").toURI();
        File file = new File(uri);
        ProxyDTO proxyDTO = objectMapper.readValue(file, ProxyDTO.class);
        System.out.println("");
    }
}
