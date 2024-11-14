--Roles

INSERT INTO roles (nombre, descripcion)
VALUES ('SuperUser', 'Nivel de acceso más alto con todos los permisos'),
       ('Administrador', 'Gestiona la configuración del sistema y el acceso de usuarios'),
       ('Psicologo', 'Profesional que brinda asistencia psicológica'),
       ('Paciente', 'Usuario final que recibe servicios psicológicos');

--Consultorios
INSERT INTO consultorios (nombre, ubicacion, tipo, capacidad, horario_de_apertura, horario_de_cierre, activo)
VALUES ('Consultorio A', 'Edificio Principal, Piso 1', 'Psicología Infantil', 10, '08:00', '17:00', true),
       ('Consultorio B', 'Edificio Principal, Piso 2', 'Psicología Familiar', 8, '09:00', '18:00', true),
       ('Consultorio C', 'Edificio Anexo, Piso 1', 'Psicología Clínica', 12, '10:00', '19:00', true),
       ('Consultorio D', 'Edificio Anexo, Piso 2', 'Psicología de Pareja', 6, '08:30', '16:30', false),
       ('Consultorio E', 'Edificio Principal, Piso 3', 'Psicología Laboral', 15, '07:00', '15:00', true);
