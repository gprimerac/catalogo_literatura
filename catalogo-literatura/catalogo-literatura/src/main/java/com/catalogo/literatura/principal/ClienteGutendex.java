package com.catalogo.literatura.principal;

import com.catalogo.literatura.modelo.Libro;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ClienteGutendex {

    private static final String URL =
            "https://gutendex.com/books?search={palabra}";

    public List<Libro> buscarLibros(String palabra) {

        RestTemplate restTemplate = new RestTemplate();

        DatosGutendex respuesta = restTemplate.getForObject(
                URL,
                DatosGutendex.class,
                palabra
        );

        if (respuesta == null || respuesta.results().isEmpty()) {
            return List.of();
        }

        return respuesta.results()
                .stream()
                .map(DatosLibro::toLibro)
                .toList();
    }
}


