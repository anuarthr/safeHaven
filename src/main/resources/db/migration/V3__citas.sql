--Citas

INSERT INTO citas (id, motivo, duracion, tipo_cita, insert_by, update_by, fecha, hora, paciente_id, psicologo_id, consultorio_id)
VALUES
    (1, 'Consulta inicial', '01:00', 'Presencial', 'pedro.ramirez@example.com', NULL, '2024-06-01', '09:00', 6, 1, 1),
    (2, 'Seguimiento mensual', '00:45', 'Virtual', 'laura.perez@example.com', NULL, '2024-06-02', '10:30', 7, 2, 2),
    (3, 'Evaluación psicológica', '01:30', 'Presencial', 'jorge.gonzalez@example.com', NULL, '2024-06-03', '11:00', 8, 3, 3),
    (4, 'Terapia de pareja', '01:00', 'Presencial', 'marta.sanchez@example.com', NULL, '2024-06-04', '12:00', 9, 4, 4),
    (5, 'Orientación laboral', '00:30', 'Virtual', 'andres.lopez@example.com', NULL, '2024-06-05', '13:00', 10, 5, 5);

