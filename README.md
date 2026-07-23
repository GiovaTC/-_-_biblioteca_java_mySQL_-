# -_-_biblioteca_java_mySQL_- :.
# 📚 BibliotecaJavaMySQL:

<img width="1254" height="1254" alt="image" src="https://github.com/user-attachments/assets/dd0c5385-14b1-4a20-ad21-0fac886e948d" />    

<img width="2549" height="1038" alt="image" src="https://github.com/user-attachments/assets/fc6e395e-aa1a-4ff6-9a30-1aa6b42618c3" />    

```
Proyecto muy básico para practicar **Java 21 + IntelliJ IDEA + Consola + MySQL 8 + JDBC**.

---

# Objetivo

Desarrollar una aplicación de consola que permita administrar una pequeña biblioteca utilizando **MySQL 8** mediante **JDBC**.

El proyecto implementa las operaciones básicas de un **CRUD (Create, Read, Update, Delete)** siguiendo una arquitectura por capas para facilitar el aprendizaje de la Programación Orientada a Objetos (POO).

---

# Tecnologías utilizadas

- Java 21
- IntelliJ IDEA
- MySQL 8
- JDBC
- Maven

---

# Funcionalidades

El programa permitirá:

- ✅ Agregar libros
- ✅ Consultar todos los libros
- ✅ Buscar un libro por ID
- ✅ Actualizar información
- ✅ Eliminar un libro
- ✅ Salir del programa

---

# Base de Datos

## Crear la base de datos

```sql
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

CREATE TABLE libros(

    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(120) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    editorial VARCHAR(80),
    anio INT,
    disponible BOOLEAN

);
```

---

# Menú Principal

```
===============================
     BIBLIOTECA JAVA MYSQL
===============================

1. Agregar libro
2. Mostrar libros
3. Buscar libro
4. Actualizar libro
5. Eliminar libro
6. Salir

Seleccione:
```

---

# Ejemplo de ejecución

## Agregar libro

```
Título:
Java desde Cero

Autor:
Juan Pérez

Editorial:
Alfaomega

Año:
2025

Disponible (true/false):
true

Libro registrado correctamente.
```

---

## Mostrar libros

```
ID: 1

Título:
Java desde Cero

Autor:
Juan Pérez

Editorial:
Alfaomega

Año:
2025

Disponible:
Sí
```

---

## Buscar libro

```
Ingrese ID:

1

Libro encontrado.
```

---

## Eliminar libro

```
Ingrese ID:

1

Libro eliminado.
```

---

# Estructura del proyecto

```
BibliotecaJavaMySQL
│
├── pom.xml
│
├── README.md
│
└── src
    └── main
        └── java
            │
            ├── config
            │      ConexionBD.java
            │
            ├── modelo
            │      Libro.java
            │
            ├── dao
            │      LibroDAO.java
            │
            ├── util
            │      Menu.java
            │
            └── Main.java
```

---

# Arquitectura del proyecto

```
               +----------------------+
               |       Main.java      |
               +----------+-----------+
                          |
                          |
                          ▼
                  +---------------+
                  |   Menu.java   |
                  +-------+-------+
                          |
                          |
                          ▼
                  +---------------+
                  |  LibroDAO.java|
                  +-------+-------+
                          |
                          |
                          ▼
                +-------------------+
                |  ConexionBD.java  |
                +---------+---------+
                          |
                          ▼
                     MySQL 8
```

---

# Clases del proyecto

## ConexionBD.java

### Responsabilidades

- Abrir conexión
- Cerrar conexión
- Ejecutar INSERT
- Ejecutar UPDATE
- Ejecutar DELETE
- Ejecutar SELECT

---

## Libro.java

Representa la entidad **Libro**.

### Atributos

```text
id
titulo
autor
editorial
anio
disponible
```

### Responsabilidades

- Encapsular la información del libro.
- Proporcionar constructores.
- Proporcionar getters y setters.
- Sobrescribir el método `toString()`.

---

## LibroDAO.java

Contiene todas las operaciones sobre la base de datos.

### Métodos

```java
insertarLibro()

listarLibros()

buscarLibro()

actualizarLibro()

eliminarLibro()
```

---

## Menu.java

Responsabilidades:

- Mostrar el menú.
- Capturar datos mediante `Scanner`.
- Validar entradas básicas.
- Invocar los métodos del DAO.

---

## Main.java

Controla el ciclo principal del programa.

```java
while(opcion != 6){

    mostrarMenu();

    switch(opcion){

        case 1:
            agregar();
            break;

        case 2:
            listar();
            break;

        case 3:
            buscar();
            break;

        case 4:
            actualizar();
            break;

        case 5:
            eliminar();
            break;

    }

}
```

---

# Flujo del programa

```
Inicio
   │
   ▼
Mostrar menú
   │
   ▼
Leer opción
   │
   ▼
┌───────────────┐
│    Switch     │
└──────┬────────┘
       │
       ├──► Agregar libro
       │
       ├──► Mostrar libros
       │
       ├──► Buscar libro
       │
       ├──► Actualizar libro
       │
       ├──► Eliminar libro
       │
       └──► Salir
```

---

# Operaciones CRUD

## CREATE

Registrar un nuevo libro.

```sql
INSERT INTO libros
(titulo,autor,editorial,anio,disponible)
VALUES(?,?,?,?,?);
```

---

## READ

Consultar todos los libros.

```sql
SELECT * FROM libros;
```

---

## Buscar por ID

```sql
SELECT * FROM libros
WHERE id = ?;
```

---

## UPDATE

Actualizar la información de un libro.

```sql
UPDATE libros
SET
titulo=?,
autor=?,
editorial=?,
anio=?,
disponible=?
WHERE id=?;
```

---

## DELETE

Eliminar un libro.

```sql
DELETE FROM libros
WHERE id=?;
```

---

# Conceptos de Java que practicarás

Durante este proyecto se pondrán en práctica los siguientes conceptos:

- Clases
- Objetos
- Encapsulamiento
- Constructores
- Métodos
- Getters y Setters
- Scanner
- ArrayList
- JDBC
- Connection
- PreparedStatement
- ResultSet
- CRUD
- Programación Orientada a Objetos
- Arquitectura por capas
- Manejo de excepciones
- Menús de consola

---

# Arquitectura por capas

```
               PRESENTACIÓN
            (Main + Menu)

                   │
                   ▼

             CAPA DAO
          (LibroDAO.java)

                   │
                   ▼

        CAPA DE CONEXIÓN
        (ConexionBD.java)

                   │
                   ▼

              MySQL 8
```

---

# Dependencia JDBC (Maven)

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.3.0</version>
</dependency>
```

---

# Requisitos

- JDK 21
- IntelliJ IDEA
- Maven
- MySQL Server 8
- MySQL Workbench (opcional)

---

# Configuración de la conexión

Ejemplo de configuración:

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/biblioteca_db";

private static final String USER =
        "root";

private static final String PASSWORD =
        "123456";
```

---

# Resultado esperado

El programa permitirá administrar una pequeña biblioteca desde consola, realizando operaciones CRUD directamente sobre una base de datos MySQL mediante JDBC.

---

# Lo que aprenderás

Este proyecto es ideal para practicar:

- ✅ Java 21
- ✅ IntelliJ IDEA
- ✅ Programación Orientada a Objetos (POO)
- ✅ JDBC
- ✅ MySQL 8
- ✅ CRUD completo
- ✅ Arquitectura por capas
- ✅ Uso de Scanner
- ✅ PreparedStatement
- ✅ ResultSet
- ✅ Manejo de excepciones
- ✅ Aplicaciones de consola
- ✅ Separación de responsabilidades
- ✅ Persistencia de datos con MySQL

---

# Autor

**Giovanny Alejandro Tapiero Cataño**

Proyecto académico para practicar:

- Java 21
- IntelliJ IDEA
- JDBC
- MySQL 8
- Programación Orientada a Objetos
- Arquitectura por capas
- Desarrollo de aplicaciones de consola

---

# Licencia

Proyecto de uso académico y educativo.
:. . / . 
