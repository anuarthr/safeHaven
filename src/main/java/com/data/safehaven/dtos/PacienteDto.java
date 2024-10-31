package com.data.safehaven.dtos;

import java.util.Date;

public record PacienteDto(Long id, String aseguradora, String estadoDeSalud, Date fechaDeRegistro) {

}
