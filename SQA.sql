-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS gsqa_prueba;

-- Usar la base de datos
USE gsqa_prueba;

-- Crear la tabla empleados
CREATE TABLE IF NOT EXISTS empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    cargo VARCHAR(100),
    correo VARCHAR(150),
    telefono VARCHAR(20)
);