package org.example.dao;

import org.example.config.ConexionBD;
import org.example.modelo.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ==========================================================
 * Clase: LibroDAO
 * Proyecto: BibliotecaLibros
 * Autor: Giovanny A. Tapiero C .
 * Java: 21
 * Base de Datos: MySQL 8
 * ==========================================================
 *
 * Responsabilidades:
 * - Insertar libros.
 * - Consultar todos los libros.
 * - Buscar un libro por ID.
 * - Actualizar libros.
 * - Eliminar libros.
 */
public class LibroDAO {

    /**
     * Inserta un libro en la base de datos .
     */
    public boolean guardar(Libro libro) {

        String sql = """
                INSERT INTO libros
                (titulo, autor, editorial, anio, isbn)
                VALUES (?,?,?,?,?)
                """;
        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getEditorial());
            ps.setInt(4, libro.getAnio());
            ps.setString(5, libro.getIsbn());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al guardar libro: " + e.getMessage());
        }

        return false;
    }
    /**
     * Devuelve todos los libros .
     */
    public List<Libro> listar() {

        List<Libro> lista = new ArrayList<>();

        String sql = "SELECT * FROM libros ORDER BY id";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement  ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while ( rs.next()) {

                Libro libro = new Libro();

                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setAnio(rs.getInt("anio"));
                libro.setIsbn(rs.getString("isbn"));

                lista.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar libros: " + e.getMessage());
        }

        return lista;
    }
        /**
         * Busca un libro por ID.
         */
        public Libro buscarPorId(int id) {

            String sql = "SELECT * FROM libros WHERE id=?";

            try (Connection conexion = ConexionBD.conectar();
                 PreparedStatement ps = conexion.prepareStatement(sql)) {

                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {

                        Libro libro = new Libro();

                        libro.setId(rs.getInt("id"));
                        libro.setTitulo(rs.getString("titulo"));
                        libro.setAutor(rs.getString("autor"));
                        libro.setEditorial(rs.getString("editorial"));
                        libro.setAnio(rs.getInt("anio"));
                        libro.setIsbn(rs.getString("isbn"));

                        return libro;
                    }
                }

            } catch (SQLException e) {
                System.out.println("Error al buscar libro: " + e.getMessage());
            }

            return null;
        }

        /**
         * Actualiza un libro existente.
         */
        public boolean actualizar(Libro libro) {

            String sql = """
                UPDATE libros
                SET titulo=?,
                    autor=?,
                    editorial=?,
                    anio=?,
                    isbn=?
                WHERE id=?
                """;

            try (Connection conexion = ConexionBD.conectar();
                 PreparedStatement ps = conexion.prepareStatement(sql)) {

                ps.setString(1, libro.getTitulo());
                ps.setString(2, libro.getAutor());
                ps.setString(3, libro.getEditorial());
                ps.setInt(4, libro.getAnio());
                ps.setString(5, libro.getIsbn());
                ps.setInt(6, libro.getId());

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                System.out.println("Error al actualizar libro: " + e.getMessage());
            }

            return false;
        }

        /**
         * Elimina un libro por ID.
         */
        public boolean eliminar(int id) {

            String sql = "DELETE FROM libros WHERE id=?";

            try (Connection conexion = ConexionBD.conectar();
                 PreparedStatement ps = conexion.prepareStatement(sql)) {

                ps.setInt(1, id);

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                System.out.println("Error al eliminar libro: " + e.getMessage());
            }

            return false;
        }
    }
