package com.catalogo.literatura.principal;

import com.catalogo.literatura.modelo.Libro;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DatosLibro(
        String title,
        List<Autor> authors,
        List<String> languages,
        @JsonProperty("download_count") int downloadCount
) {

    public Libro toLibro() {

        String autor = "Autor desconocido";
        Integer nacimiento = null;
        Integer fallecimiento = null;

        if (authors != null && !authors.isEmpty()) {
            Autor a = authors.get(0);
            autor = a.name();
            nacimiento = a.birthYear();
            fallecimiento = a.deathYear();
        }

        String idioma = (languages != null && !languages.isEmpty())
                ? languages.get(0)
                : "N/A";

        return new Libro(
                title,
                autor,
                idioma,
                downloadCount,
                nacimiento,
                fallecimiento
        );
    }

    public record Autor(
            String name,
            @JsonProperty("birth_year") Integer birthYear,
            @JsonProperty("death_year") Integer deathYear
    ) {}
}
