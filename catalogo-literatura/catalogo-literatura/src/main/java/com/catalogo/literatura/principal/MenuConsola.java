package com.catalogo.literatura.principal;

import com.catalogo.literatura.modelo.Libro;
import com.catalogo.literatura.repositorio.RepositorioLibros;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuConsola implements CommandLineRunner {

    private final RepositorioLibros repositorio;
    private final ClienteGutendex clienteGutendex;
    private final Scanner scanner = new Scanner(System.in);

    public MenuConsola(RepositorioLibros repositorio,
                       ClienteGutendex clienteGutendex) {
        this.repositorio = repositorio;
        this.clienteGutendex = clienteGutendex;
    }

    @Override
    public void run(String... args) {

        int opcion;

        do {
            System.out.println("""
                    
                    ===== CATÁLOGO DE LITERATURA =====
                    1 - Buscar libros desde la API
                    2 - Buscar libros por autor
                    3 - Buscar libros por título
                    4 - Top 10 libros más descargados
                    5 - Cantidad de libros en español e inglés
                    6 - Listar autores vivos en un año
                    0 - Salir
                    """);

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> buscarDesdeApi();
                case 2 -> buscarPorAutor();
                case 3 -> buscarPorTitulo();
                case 4 -> top10Descargados();
                case 5 -> estadisticasPorIdioma();
                case 6 -> autoresVivosPorAnio();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

    // ================================
    private void buscarDesdeApi() {

        System.out.print("Ingrese palabra clave: ");
        String palabra = scanner.nextLine();

        List<Libro> librosApi = clienteGutendex.buscarLibros(palabra);

        if (librosApi.isEmpty()) {
            System.out.println("No se encontraron libros en la API.");
            return;
        }

        int guardados = 0;

        for (Libro libro : librosApi) {

            if (!repositorio
                    .findByTituloContainingIgnoreCase(libro.getTitulo())
                    .isEmpty()) {
                continue;
            }

            repositorio.save(libro);
            guardados++;
        }

        System.out.println("Libros guardados: " + guardados);
    }

    // ================================
    private void buscarPorAutor() {
        System.out.print("Autor: ");
        repositorio.findByAutorContainingIgnoreCase(scanner.nextLine())
                .forEach(this::mostrarLibro);
    }

    // ================================
    private void buscarPorTitulo() {
        System.out.print("Título: ");
        repositorio.findByTituloContainingIgnoreCase(scanner.nextLine())
                .forEach(this::mostrarLibro);
    }

    // ================================
    private void top10Descargados() {
        repositorio.findTop10ByOrderByDescargasDesc()
                .forEach(this::mostrarLibro);
    }

    // ================================
    private void estadisticasPorIdioma() {

        long es = repositorio.findAll().stream()
                .filter(l -> "es".equalsIgnoreCase(l.getIdioma()))
                .count();

        long en = repositorio.findAll().stream()
                .filter(l -> "en".equalsIgnoreCase(l.getIdioma()))
                .count();

        System.out.println("Español: " + es);
        System.out.println("Inglés: " + en);
    }

    // ================================
    private void autoresVivosPorAnio() {

        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        scanner.nextLine();

        repositorio.findAll().stream()
                .filter(l ->
                        l.getAnioNacimiento() != null &&
                                l.getAnioNacimiento() <= anio &&
                                (l.getAnioFallecimiento() == null ||
                                        l.getAnioFallecimiento() >= anio)
                )
                .map(Libro::getAutor)
                .distinct()
                .forEach(a -> System.out.println("- " + a));
    }

    // ================================
    private void mostrarLibro(Libro l) {
        System.out.println("""
                ----------------------------
                Título: %s
                Autor: %s
                Idioma: %s
                Descargas: %d
                Nacimiento: %s
                Fallecimiento: %s
                ----------------------------
                """.formatted(
                l.getTitulo(),
                l.getAutor(),
                l.getIdioma(),
                l.getDescargas(),
                l.getAnioNacimiento(),
                l.getAnioFallecimiento()
        ));
    }
}







