package com.catalogo.literatura.repositorio;

import com.catalogo.literatura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioLibros extends JpaRepository<Libro, Long> {

    // libros por autor
    List<Libro> findByAutorContainingIgnoreCase(String autor);

    // libros por título
    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    // ⭐ Top 10 libros más descargados
    List<Libro> findTop10ByOrderByDescargasDesc();
}

