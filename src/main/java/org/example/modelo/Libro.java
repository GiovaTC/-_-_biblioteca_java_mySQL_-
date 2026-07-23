package org.example.modelo;

/**
 * ==========================================================
 * Clase: Libro
 * Proyecto: BibliotecaJavaMySQL
 * Autor: Giovanny Alejandro Tapiero Cataño .
 * Java: 21
 * ==========================================================
 *
 * Representa la entidad Libro de la biblioteca.
 */

public class Libro {

    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private int anio;
    private boolean disponible;
    private String isbn;


    /**
     * Constructor vacío .
     */
    public Libro() {

    }

    /**
     * Constructor sin ID.
     *
     * @param titulo      Título del libro
     * @param autor       Autor del libro
     * @param editorial   Editorial
     * @param anio        Año de publicación
     * @param disponible  Disponibilidad del libro
     */
    public Libro(String titulo,
                 String autor,
                 String editorial,
                 int anio,
                 boolean disponible) {

        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.disponible = disponible;
    }

    /**
     * Constructor completo .
     *
     * @param id          Identificador
     * @param titulo      Título
     * @param autor       Autor
     * @param editorial   Editorial
     * @param anio        Año
     * @param disponible  Disponibilidad
     */
    public Libro(int id,
                 String titulo,
                 String autor,
                 String editorial,
                 int anio,
                 boolean disponible) {

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.disponible = disponible;
    }


    // =====================================================
    // Getters y Setters
    // =====================================================


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // =====================================================
    // toString()
    // =====================================================
    @Override
    public String toString() {

        return """
                ----------------------------------------
                ID          : %d
                Título      : %s
                Autor       : %s
                Editorial   : %s
                Año         : %d
                Disponible  : %s
                ----------------------------------------
                """.formatted(
                        id,
                    titulo,
                     autor,
                    editorial,
                    anio,
                    disponible ? "Sí" : "No"
        );
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

