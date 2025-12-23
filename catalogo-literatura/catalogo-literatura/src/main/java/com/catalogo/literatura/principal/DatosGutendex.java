package com.catalogo.literatura.principal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record DatosGutendex(
        @JsonProperty("results")
        List<DatosLibro> results
) {}
