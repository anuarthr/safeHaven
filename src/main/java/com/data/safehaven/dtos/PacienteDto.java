package com.data.safehaven.dtos;

import java.util.Date;

public record PacienteDto(Long id,
                          String nombre,
                          String apellido,
                          String correoElectronico,
                          String password,
                          Integer edad,
                          Long telefono,
                          String sexo,
                          Date fechaDeNacimiento,
                          String aseguradora,
                          String estadoDeSalud,
                          Date fechaDeRegistro,
                          Long rol) {
}
