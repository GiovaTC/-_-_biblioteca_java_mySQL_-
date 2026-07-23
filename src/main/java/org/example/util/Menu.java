package org.example.util;

import org.example.dao.LibroDAO;
import org.example.modelo.Libro;

import java.util.List;
import java.util.Scanner;

/**
 * ==========================================================
 * Clase: Menu
 * Proyecto: BibliotecaLibros
 * Autor: Giovanny A. Tapiero C .
 * Java: 21
 * Base de Datos: MySQL 8
 * ==========================================================
 *
 * Responsabilidades:
 * - Mostrar el menú principal.
 * - Capturar la información del usuario.
 * - Invocar las operaciones del LibroDAO.
 */

public class Menu {

    private final Scanner scanner;
    private final LibroDAO libroDAO;

    public Menu() {
        scanner = new Scanner(System.in);
        libroDAO = new LibroDAO();
    }

    /**
     * Inicia el menú principal .
     */
    public void iniciar() {

        int opcion;

        do {
            System.out.println();
            System.out.println("==========================================");
            System.out.println("      BIBLIOTECA DE LIBROS");
            System.out.println("==========================================");
            System.out.println("1. Registrar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por ID");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("0. Salir");
            System.out.println("==========================================");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {

                case 1 -> registrarLibro();

                case 2 -> listarLibros();

                case 3 -> buscarLibro();

                case 4 -> actualizarLibro();

                case 5 -> eliminarLibro();

                case 0 -> System.out.println("\nGracias por utilizar la Biblioteca.");

                default -> System.out.println("\nOpción inválida.");

            }

        } while (opcion != 0);

    }

    /**
     * Registrar un libro.
     */
    private void registrarLibro() {

        System.out.println("\n--- REGISTRAR LIBRO ---");

        Libro libro = new Libro();

        System.out.print("Título: ");
        libro.setTitulo(scanner.nextLine());

        System.out.print("Autor: ");
        libro.setAutor(scanner.nextLine());

        System.out.print("Editorial: ");
        libro.setEditorial(scanner.nextLine());

        System.out.print("Año: ");
        libro.setAnio(leerEntero());

        System.out.print("ISBN: ");
        libro.setIsbn(scanner.nextLine());

        if (libroDAO.guardar(libro)) {
            System.out.println("\nLibro registrado correctamente.");
        } else {
            System.out.println("\nNo fue posible registrar el libro.");
        }

    }

    /**
     * Mostrar todos los libros.
     */
    private void listarLibros() {

        System.out.println("\n--- LISTADO DE LIBROS ---");

        List<Libro> libros = libroDAO.listar();

        if (libros.isEmpty()) {

            System.out.println("No existen libros registrados.");
            return;

        }

        for (Libro libro : libros) {

            System.out.println("--------------------------------------");
            System.out.println("ID         : " + libro.getId());
            System.out.println("Título     : " + libro.getTitulo());
            System.out.println("Autor      : " + libro.getAutor());
            System.out.println("Editorial  : " + libro.getEditorial());
            System.out.println("Año        : " + libro.getAnio());
            System.out.println("ISBN       : " + libro.getIsbn());

        }

    }

    /**
     * Buscar un libro por ID.
     */
    private void buscarLibro() {

        System.out.print("\nIngrese el ID del libro: ");

        int id = leerEntero();

        Libro libro = libroDAO.buscarPorId(id);

        if (libro == null) {

            System.out.println("Libro no encontrado.");
            return;

        }

        System.out.println("\nLibro encontrado:");
        System.out.println("--------------------------------------");
        System.out.println("ID         : " + libro.getId());
        System.out.println("Título     : " + libro.getTitulo());
        System.out.println("Autor      : " + libro.getAutor());
        System.out.println("Editorial  : " + libro.getEditorial());
        System.out.println("Año        : " + libro.getAnio());
        System.out.println("ISBN       : " + libro.getIsbn());

    }

    /**
     * Actualizar un libro.
     */
    private void actualizarLibro() {

        System.out.print("\nIngrese el ID del libro a actualizar: ");

        int id = leerEntero();

        Libro libro = libroDAO.buscarPorId(id);

        if (libro == null) {

            System.out.println("Libro no encontrado.");
            return;

        }

        System.out.println("Nuevo título: ");
        libro.setTitulo(scanner.nextLine());

        System.out.println("Nuevo autor: ");
        libro.setAutor(scanner.nextLine());

        System.out.println("Nueva editorial: ");
        libro.setEditorial(scanner.nextLine());

        System.out.println("Nuevo año: ");
        libro.setAnio(leerEntero());

        System.out.println("Nuevo ISBN: ");
        libro.setIsbn(scanner.nextLine());

        if (libroDAO.actualizar(libro)) {

            System.out.println("\nLibro actualizado correctamente.");

        } else {

            System.out.println("\nNo fue posible actualizar el libro.");
        }
    }

    /**
     * Eliminar un libro.
     */
    private void eliminarLibro() {

        System.out.print("\nIngrese el ID del libro a eliminar: ");
        int id = leerEntero();

        if (libroDAO.eliminar(id)) {

            System.out.println("\nLibro eliminado correctamente.");
        } else {

            System.out.println("\nNo fue posible eliminar el libro.");

        }
    }

    /**
     * Lee un entero evitando errores de entrada.
     */
    private int leerEntero() {

        while (!scanner.hasNextInt()) {

            System.out.print("Ingrese un número válido: ");
            scanner.next();

        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        return numero;
    }   
}