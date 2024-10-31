package com.data.safehaven.dtos;

import java.util.Date;

public record HistorialClinicoDto(Long id, Date fechaDeCreacion,
                                  String comentarios) {
}
