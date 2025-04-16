DELIMITER //

CREATE PROCEDURE insertar_pedido (
    IN p_unidades INT,
    IN p_fecha DATETIME,
    IN p_cliente_email VARCHAR(100),
    IN p_articulo_codigo VARCHAR(20)
)
BEGIN
    INSERT INTO pedidos (unidades, fecha_pedido, cliente_email, articulo_codigo)
    VALUES (p_unidades, p_fecha, p_cliente_email, p_articulo_codigo);
END //

DELIMITER ;