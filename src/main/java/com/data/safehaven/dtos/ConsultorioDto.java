package com.data.safehaven.dtos;

import java.time.LocalTime;

public record ConsultorioDto(Long id,
                             String nombre,
                             String ubicacion,
                             String tipo,
                             Integer capacidad,
                             LocalTime horarioDeApertura,
                             LocalTime horarioDeCierre,
                             boolean activo) {
}
