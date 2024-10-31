package com.data.safehaven.dtos;

import java.time.LocalDateTime;

public record CitaDto(Long id, String motivo, LocalDateTime duracion, String tipoCita, String insertBy, String updateBy) {
}
