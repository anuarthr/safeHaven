INSERT INTO roles (id, nombre, descripcion) VALUES (1, 'SuperUser', 'Nivel de acceso más alto con todos los permisos')
    ON CONFLICT (id) DO NOTHING;
INSERT INTO roles (id, nombre, descripcion) VALUES (2, 'Administrador', 'Gestiona la configuración del sistema y el acceso de usuarios')
    ON CONFLICT (id) DO NOTHING;
INSERT INTO roles (id, nombre, descripcion) VALUES (3, 'Psicologo', 'Profesional que brinda asistencia psicológica')
    ON CONFLICT (id) DO NOTHING;
INSERT INTO roles (id, nombre, descripcion) VALUES (4, 'Paciente', 'Usuario final que recibe servicios psicológicos')
    ON CONFLICT (id) DO NOTHING;