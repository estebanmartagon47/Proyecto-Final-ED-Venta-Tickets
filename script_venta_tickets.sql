CREATE DATABASE IF NOT EXISTS venta_tickets_parque
CHARACTER SET utf8mb4
COLLATE utf8mb4_spanish2_ci;

CREATE USER IF NOT EXISTS 'ticketapp_user'@'localhost'
IDENTIFIED BY 'Ticket2026*';

GRANT ALL PRIVILEGES
ON venta_tickets_parque.*
TO 'ticketapp_user'@'localhost';

FLUSH PRIVILEGES;

USE venta_tickets_parque;

CREATE TABLE IF NOT EXISTS eventos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    fecha DATE NOT NULL,
    horario VARCHAR(50),
    ubicacion VARCHAR(100)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_spanish2_ci;

CREATE TABLE IF NOT EXISTS tipos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(8,2) NOT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_spanish2_ci;

CREATE TABLE IF NOT EXISTS ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    evento_id INT NOT NULL,
    tipo_id INT NOT NULL,
    nombre_cliente VARCHAR(100) NOT NULL,
    dni_email VARCHAR(100) NOT NULL,
    fecha_compra DATETIME DEFAULT CURRENT_TIMESTAMP,
    cantidad INT NOT NULL,
    total_pagado DECIMAL(8,2) NOT NULL,

    CONSTRAINT fk_evento
    FOREIGN KEY (evento_id) REFERENCES eventos(id),

    CONSTRAINT fk_tipo
    FOREIGN KEY (tipo_id) REFERENCES tipos(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_spanish2_ci;

INSERT INTO eventos (nombre, descripcion, fecha, horario, ubicacion)
VALUES
('Montaña Rusa Extrema', 'Atracción de alta velocidad y adrenalina', '2026-06-10', '10:00 - 20:00', 'Zona Norte'),
('Casa del Terror', 'Experiencia inmersiva de miedo', '2026-06-12', '18:00 - 00:00', 'Zona Oeste'),
('Parque Acuático', 'Diversión acuática para toda la familia', '2026-06-15', '11:00 - 19:00', 'Zona Sur');

INSERT INTO tipos (nombre, descripcion, precio)
VALUES
('Adulto', 'Entrada general para adultos', 35.00),
('Infantil', 'Entrada para menores de 12 años', 20.00),
('VIP', 'Acceso prioritario y zonas exclusivas', 60.00);

SELECT * FROM eventos;
SELECT * FROM tipos;
SELECT * FROM ventas;