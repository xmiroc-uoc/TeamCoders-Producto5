-- Elimina el esquema si ya existe
DROP DATABASE IF EXISTS TeamCodersBD;

-- Crea el nuevo esquema
CREATE DATABASE TeamCodersBD CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Usa el esquema
USE TeamCodersBD;

-- Tabla de clientes
CREATE TABLE clientes (
    email VARCHAR(100) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    domicilio VARCHAR(255),
    nif VARCHAR(20) NOT NULL,
    tipo ENUM('estandar', 'premium') NOT NULL,
    cuota_anual DOUBLE DEFAULT NULL
);

-- Tabla de artículos
CREATE TABLE articulos (
    codigo VARCHAR(20) PRIMARY KEY,
    descripcion VARCHAR(255),
    precio_venta DOUBLE NOT NULL,
    gastos_envio DOUBLE NOT NULL,
    tiempo_preparacion INT NOT NULL
);

-- Tabla de pedidos
CREATE TABLE pedidos (
    numero INT AUTO_INCREMENT PRIMARY KEY,
    unidades INT NOT NULL,
    fecha_pedido DATETIME NOT NULL,
    cliente_email VARCHAR(100),
    articulo_codigo VARCHAR(20),
    FOREIGN KEY (cliente_email) REFERENCES clientes(email)
        ON DELETE SET NULL
        ON UPDATE CASCADE,
    FOREIGN KEY (articulo_codigo) REFERENCES articulos(codigo)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);
