-- Procedimiento para insertar un artículo
DELIMITER //

CREATE PROCEDURE insertar_articulo (
    IN p_codigo VARCHAR(20),
    IN p_descripcion VARCHAR(255),
    IN p_precio_venta DECIMAL(10,2),
    IN p_gastos_envio DECIMAL(10,2),
    IN p_tiempo_preparacion INT
)
BEGIN
	INSERT INTO articulos(codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion)
    VALUES (p_codigo, p_descripcion, p_precio_venta, p_gastos_envio, p_tiempo_preparacion);
END //

DELIMITER ;
