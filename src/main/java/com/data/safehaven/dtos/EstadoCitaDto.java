package com.data.safehaven.dtos;

import java.util.Date;

public record EstadoCitaDto(Long idEstadoCita,
                            Date fechaInicioEstado,
                            Date fechaFinEstado,
                            Date fechaInicioDeRegistroEstado,
                            Date fechaFinDeRegistroEstado) {
}
