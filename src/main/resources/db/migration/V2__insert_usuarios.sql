
--Usuarios
INSERT INTO usuarios (nombre, apellido, correo_electronico, password, edad, telefono, sexo, fecha_de_nacimiento, id_rol)
VALUES
    ('Ana', 'Gómez', 'ana.gomez@example.com', 'password123', 34, 5551234567, 'F', '1990-05-15', 3),
    ('Carlos', 'Hernández', 'carlos.hernandez@example.com', 'password456', 42, 5559876543, 'M', '1982-09-22', 3),
    ('Lucía', 'Martínez', 'lucia.martinez@example.com', 'password789', 29, 5556543210, 'F', '1995-02-10', 3),
    ('Diego', 'Fernández', 'diego.fernandez@example.com', 'password101', 37, 5553332221, 'M', '1987-12-30', 3),
    ('María', 'López', 'maria.lopez@example.com', 'password202', 31, 5551112223, 'F', '1993-07-18', 3),

    ('Pedro', 'Ramírez', 'pedro.ramirez@example.com', 'pass123', 28, 5551234567, 'M', '1996-01-10', 4),
    ('Laura', 'Pérez', 'laura.perez@example.com', 'pass456', 34, 5559876543, 'F', '1990-08-25', 4),
    ('Jorge', 'González', 'jorge.gonzalez@example.com', 'pass789', 40, 5556543210, 'M', '1984-11-13', 4),
    ('Marta', 'Sánchez', 'marta.sanchez@example.com', 'pass101', 25, 5553332221, 'F', '1999-05-18', 4),
    ('Andrés', 'López', 'andres.lopez@example.com', 'pass202', 30, 5551112223, 'M', '1993-02-22', 4);

--Psicologos
INSERT INTO psicologos (id, especialidad, años_de_experiencia, horario_de_atencion)
VALUES
    (1, 'Psicología Clínica', 10, 'Lunes a Viernes 9:00 - 17:00'),
    (2, 'Psicología Infantil', 15, 'Lunes a Viernes 10:00 - 18:00'),
    (3, 'Psicología Familiar', 5, 'Lunes a Jueves 11:00 - 17:00'),
    (4, 'Psicología Laboral', 12, 'Martes a Sábado 12:00 - 19:00'),
    (5, 'Psicología de Pareja', 8, 'Lunes a Viernes 8:00 - 15:00');

--Pacientes
INSERT INTO pacientes (id, aseguradora, estado_de_salud, fecha_de_registro)
VALUES
    (6, 'Aseguradora XYZ', 'Bueno', '2024-01-15'),
    (7, 'Aseguradora ABC', 'Regular', '2024-02-20'),
    (8, 'Aseguradora XYZ', 'Excelente', '2024-03-05'),
    (9, 'Aseguradora DEF', 'Bueno', '2024-04-10'),
    (10, 'Aseguradora ABC', 'Regular', '2024-05-30');



