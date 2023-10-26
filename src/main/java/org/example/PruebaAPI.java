package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class PruebaAPI {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try {
            JsonNode rootNode = objectMapper.readTree(new URL("https://api.breakingbadquotes.xyz/v1/quotes/50"));
            List<Frase> frases = objectMapper.readValue(rootNode.traverse(), new TypeReference<>(){});

            System.out.println(buscarFrases(frases, "Walter"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Frase> buscarFrases (List<Frase> libros, String palabra){
        return libros.stream().filter((frase)-> frase.getAuthor().contains(palabra)).toList();
    }

}