DELIMITER //

-- Procedimiento para insertar un cliente
CREATE PROCEDURE insertar_cliente (
    IN p_email VARCHAR(100),
    IN p_nombre VARCHAR(100),
    IN p_domicilio VARCHAR(150),
    IN p_nif VARCHAR(20),
    IN p_tipo ENUM('estandar', 'premium'),
    IN p_cuota_anual INT
)
BEGIN
    INSERT INTO clientes (email, nombre, domicilio, nif, tipo, cuota_anual)
    VALUES (p_email, p_nombre, p_domicilio, p_nif, p_tipo, p_cuota_anual);
END //