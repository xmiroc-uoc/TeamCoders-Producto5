CREATE DATABASE
IF NOT EXISTS tienda;
USE tienda;

CREATE TABLE cliente
(
  id INT NOT NULL
  AUTO_INCREMENT,
    nombre        VARCHAR
  (100) NOT NULL,
    domicilio     VARCHAR
  (200) NOT NULL,
    nif           VARCHAR
  (20)  NOT NULL,
    email         VARCHAR
  (100) NOT NULL,
    tipo          ENUM
  ('estandar','premium') NOT NULL,
    cuota_anual   INT,
    PRIMARY KEY
  (id)
);

  CREATE TABLE articulo
  (
    codigo VARCHAR(20) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    precio_venta FLOAT NOT NULL,
    gastos_envio FLOAT NOT NULL,
    tiempo_preparacion INT NOT NULL,
    PRIMARY KEY (codigo)
  );

  CREATE TABLE pedido
  (
    numero_pedido INT NOT NULL,
    unidades INT NOT NULL,
    fecha_pedido DATETIME NOT NULL,
    cliente_id INT NOT NULL,
    articulo_codigo VARCHAR(20) NOT NULL,
    PRIMARY KEY (numero_pedido),
    FOREIGN KEY (cliente_id)      REFERENCES cliente(id),
    FOREIGN KEY (articulo_codigo) REFERENCES articulo(codigo)
  );

  DELIMITER $$
  CREATE PROCEDURE InsertarPedido(
        IN p_num     INT,
        IN p_uni     INT,
        IN p_fecha   DATETIME,
        IN p_cliente INT,
        IN p_art     VARCHAR
  (20)
)
  BEGIN
    START TRANSACTION;
  INSERT INTO pedido
  VALUES
    (p_num, p_uni, p_fecha, p_cliente, p_art);
  COMMIT;
  END$$
DELIMITER ;
