# catalogo_literatura

Proyecto desarrollado por Gabriel Primera Ceballos
Como parte del programa Oracle Next Education (ONE

Proyecto desarrollado en Java con Spring Boot que consume la API pública Gutendex para consultar libros y almacenarlos en una base de datos local.
El sistema permite buscar, guardar y consultar libros mediante un menú por consola, aplicando persistencia con Spring Data JPA.

Este proyecto fue realizado como parte del programa ONE – Oracle Next Education.

Funcionalidades:

El sistema ofrece las siguientes opciones desde consola:
Buscar libros desde la API Gutendex y guardarlos en la base de datos
Buscar libros por autor
Buscar libros por título
Mostrar el Top 10 de libros más descargados
Mostrar la cantidad de libros en español e inglés
Listar autores que estaban vivos en un año determinado

Heramientas utilizadas:
Java 17
Spring Boot
Spring Data JPA
Hibernate
H2 Database
Jackson (JSON)
Maven

Base de datos:
La base de datos se crea automáticamente al ejecutar la aplicación
No requiere configuración manual
Las tablas se generan a partir de las entidades JPA

Estructura: 

src/main/java
 └── com.catalogo.literatura
      ├── principal
      │    ├── MenuConsola.java
      │    ├── ClienteGutendex.java
      │    └── DatosLibro.java
      ├── modelo
      │    └── Libro.java
      └── repositorio
           └── RepositorioLibros.java


Como usar o ejecutar proyecto:

- Clonar el repositorio desde GitHub
- Abrir el proyecto en IntelliJ IDEA o Eclipse
- Ejecutar la clase principal con Spring Boot
- Interactuar con el sistema mediante el menú en consola

VISTA DEL CATALOGO

===== CATÁLOGO DE LITERATURA =====
1 - Buscar libros desde la API
2 - Buscar libros por autor
3 - Buscar libros por título
4 - Top 10 libros más descargados
5 - Cantidad de libros en español e inglés
6 - Listar autores vivos en un año
0 - Salir

API utilizada

- Gutendex API
API pública basada en el proyecto Gutenberg
https://gutendex.com/



