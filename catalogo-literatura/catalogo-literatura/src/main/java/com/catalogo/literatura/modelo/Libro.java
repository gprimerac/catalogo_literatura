package com.catalogo.literatura.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1500)
    private String titulo;

    @Column(length = 1000)
    private String autor;

    @Column(length = 10)
    private String idioma;

    private int descargas;

    private Integer anioNacimiento;
    private Integer anioFallecimiento;

    // ===== CONSTRUCTOR VACÍO (JPA) =====
    public Libro() {
    }

    // ===== CONSTRUCTOR PRINCIPAL =====
    public Libro(String titulo, String autor, String idioma, int descargas,
                 Integer anioNacimiento, Integer anioFallecimiento) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.descargas = descargas;
        this.anioNacimiento = anioNacimiento;
        this.anioFallecimiento = anioFallecimiento;
    }

    // ===== GETTERS =====
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getDescargas() {
        return descargas;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public Integer getAnioFallecimiento() {
        return anioFallecimiento;
    }

    // ===== SETTERS =====
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public void setAnioFallecimiento(Integer anioFallecimiento) {
        this.anioFallecimiento = anioFallecimiento;
    }
}





