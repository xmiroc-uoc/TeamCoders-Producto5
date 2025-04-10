-- Selecciona el esquema
USE TeamCodersBD;

-- Inserta clientes
INSERT INTO clientes (email, nombre, domicilio, nif, tipo, cuota_anual) VALUES
('ana@example.com', 'Ana Torres', 'Calle Falsa 123', '12345678A', 'estandar', NULL),
('luis@example.com', 'Luis Pérez', 'Avenida Real 456', '87654321B', 'premium', 30.0),
('maria@example.com', 'Maria Ruiz', 'Calle Luna 789', '23456789C', 'premium', 50.0);

-- Inserta artículos
INSERT INTO articulos (codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion) VALUES
('A001', 'Laptop Lenovo 14"', 1200.00, 20.00, 30),
('A002', 'Smartphone Samsung Galaxy', 850.00, 15.00, 20),
('A003', 'Tablet Apple iPad', 990.00, 18.00, 25);

-- Inserta pedidos (algunos enviados, otros pendientes según tiempo_preparacion)
-- Supongamos fecha actual es '2024-04-10 10:00:00'
INSERT INTO pedidos (unidades, fecha_pedido, cliente_email, articulo_codigo) VALUES
(1, '2024-04-10 09:40:00', 'ana@example.com', 'A001'), -- ya enviado
(2, '2024-04-10 09:50:00', 'luis@example.com', 'A002'), -- enviado
(1, '2024-04-10 09:55:00', 'maria@example.com', 'A003'); -- pendiente
