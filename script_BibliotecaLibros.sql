-- ==========================================================
-- Proyecto: BibliotecaLibros
-- Base de Datos: MySQL 8
-- Descripción:
-- Elimina la tabla libros si existe y la crea nuevamente.
-- ==========================================================

USE biblioteca_db;

-- Eliminar la tabla si existe
DROP TABLE IF EXISTS libros;

-- Crear la tabla
CREATE TABLE libros (

    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(120) NOT NULL,
    editorial VARCHAR(120) NOT NULL,
    anio INT NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE
);

-- ==========================================================
-- Datos de prueba
-- ==========================================================

INSERT INTO libros (titulo, autor, editorial, anio, isbn) VALUES
('Cien Años de Soledad', 'Gabriel García Márquez', 'Editorial Sudamericana', 1967, '9780307474728'),

('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Francisco de Robles', 1605, '9788420412146'),

('El Principito', 'Antoine de Saint-Exupéry', 'Reynal & Hitchcock', 1943, '9780156012195'),

('1984', 'George Orwell', 'Secker & Warburg', 1949, '9780451524935'),

('El Señor de los Anillos', 'J. R. R. Tolkien', 'Allen & Unwin', 1954, '9780618640157'),

('Crónica de una Muerte Anunciada', 'Gabriel García Márquez', 'Editorial Oveja Negra', 1981, '9780307389732'),

('La Odisea', 'Homero', 'Editorial Gredos', -700, '9788424936686'),

('Orgullo y Prejuicio', 'Jane Austen', 'T. Egerton', 1813, '9780141439518'),

('Fahrenheit 451', 'Ray Bradbury', 'Ballantine Books', 1953, '9781451673319'),

('El Código Da Vinci', 'Dan Brown', 'Doubleday', 2003, '9780307474278'),

('Clean Code', 'Robert C. Martin', 'Prentice Hall', 2008, '9780132350884'),

('Effective Java', 'Joshua Bloch', 'Addison-Wesley', 2018, '9780134685991'),

('Java: The Complete Reference', 'Herbert Schildt', 'McGraw-Hill', 2022, '9781265036677'),

('Spring in Action', 'Craig Walls', 'Manning Publications', 2022, '9781617298691'),

('Head First Java', 'Kathy Sierra', 'O''Reilly Media', 2022, '9781491910771'),

('El Alquimista', 'Paulo Coelho', 'HarperCollins', 1988, '9780061122415'),

('Harry Potter y la Piedra Filosofal', 'J. K. Rowling', 'Bloomsbury', 1997, '9780747532699'),

('Los Juegos del Hambre', 'Suzanne Collins', 'Scholastic', 2008, '9780439023481'),

('Sapiens', 'Yuval Noah Harari', 'Harvill Secker', 2011, '9780062316097'),

('Hábitos Atómicos', 'James Clear', 'Penguin Random House', 2018, '9780735211292');

-- ==========================================================
-- Verificación
-- ==========================================================

SELECT *
FROM libros
ORDER BY id;