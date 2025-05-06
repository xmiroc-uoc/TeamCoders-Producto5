# Proyecto Java - Gestión de Tienda Online

Este repositorio contiene el desarrollo de una aplicación en Java orientada a objetos con acceso a base de datos (MySQL), basada en el patrón MVC e integrando los patrones DAO y Factory. La aplicación se ejecuta en modo consola.

## 👥 Integrantes del grupo

- Alejandro Arévalo Rojas
- Ignacio Borrell Román
- Marc Soler Fortó
- Xavi Miró Carrera

## 🛠️ Tecnologías utilizadas

- Java 17
- MySQL
- JDBC
- Visual Studio Code
- Git

## 📁 Estructura del proyecto

```
TeamCoders-Producto3/
├── src/TeamCoders/         # Código fuente Java (modelo, vista, controlador, DAO)
├── lib/                    # Librería del conector JDBC
├── bin/                    # Archivos compilados
├── .vscode/                # Configuración del proyecto en VS Code
├── README.md               # Este archivo
├── .classpath              # Configuración del classpath
├── crear_procedimiento_insertar_pedido.sql  # Script SQL
```

## 🧩 Cómo usar el proyecto

### 1. Requisitos previos

- Tener instalado Java 17
- Tener instalado MySQL y crear una base de datos (por ejemplo `TeamCodersBD`)
- Tener el conector JDBC en la carpeta `lib/`

### 2. Configuración de la base de datos

1. Crea la base de datos en MySQL:

```sql
CREATE DATABASE TeamCodersBD;
USE TeamCodersBD;
```

2. Ejecuta los archivos SQL necesarios:

- **Estructura de tablas:**  
  *(Incluir nombre del archivo si está separado, ej. `estructura.sql`)*

- **Procedimiento almacenado:**  
  Ejecuta el script `crear_procedimiento_insertar_pedido.sql` incluido en este repositorio:
  
```sql
SOURCE crear_procedimiento_insertar_pedido.sql;
```

### 3. Compilación y ejecución

Desde terminal o consola:

```bash
javac -cp "lib/mysql-connector-j-9.1.0.jar" -d bin src/TeamCoders/Main.java
java -cp "bin:lib/mysql-connector-j-9.1.0.jar" TeamCoders.Main
```

O desde Visual Studio Code usando la configuración `launch.json`.

---

## 💬 Comentarios

- El campo `numero` del pedido se genera automáticamente (`AUTO_INCREMENT`).
- La inserción de pedidos se realiza usando un procedimiento almacenado (`CALL insertar_pedido(...)`) desde Java.
- Se ha añadido control de transacciones para garantizar la integridad de datos.

---

## 📌 Créditos

Este proyecto ha sido desarrollado como parte del módulo "Programación orientada a objetos con acceso a BBDD".