package org.example;

import org.example.util.Menu;

/**
 * ==========================================================
 * Clase: Main
 * Proyecto: BibliotecaLibros
 * Autor: Giovanny A. Tapiero C .
 * Java: 21
 * Base de Datos: MySQL 8
 * ==========================================================
 *
 * Punto de entrada de la aplicación.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("      SISTEMA BIBLIOTECA DE LIBROS");
        System.out.println("==============================================");
        System.out.println("Java 21 + JDBC + MySQL 8");
        System.out.println();

        Menu menu = new Menu();
        menu.iniciar();

        System.out.println();
        System.out.println("==============================================");
        System.out.println("      Programa finalizado.");
        System.out.println("==============================================");

    }
}