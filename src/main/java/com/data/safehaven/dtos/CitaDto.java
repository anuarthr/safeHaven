package com.data.safehaven.dtos;


import com.data.safehaven.entities.Consultorio;
import com.data.safehaven.entities.Paciente;
import com.data.safehaven.entities.Psicologo;

import java.time.LocalTime;
import java.util.Date;

public record CitaDto(Long id,
                      String motivo,
                      LocalTime duracion,
                      String tipoCita,
                      String insertBy,
                      String updateBy,
                      Date fecha,
                      LocalTime hora,
                      Long paciente,
                      Long psicologo,
                      Long consultorio) {
}
