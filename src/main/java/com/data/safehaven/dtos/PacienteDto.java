package com.data.safehaven.dtos;

import com.data.safehaven.entities.Paciente;
import com.data.safehaven.entities.Rol;

import java.util.Date;

public record PacienteDto(Long id,
                          String nombre,
                          String apellido,
                          String correoElectronico,
                          String password,
                          Integer edad,
                          Integer telefono,
                          String sexo,
                          Date fechaDeNacimiento,
                          String aseguradora,
                          String estadoDeSalud,
                          Date fechaDeRegistro,
                          Long rol) {
}
