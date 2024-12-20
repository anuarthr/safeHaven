package com.data.safehaven.dtos;

import com.data.safehaven.entities.Rol;

import java.util.Date;

public record PsicologoDto(Long id,
                           String nombre,
                           String apellido,
                           Long rol,
                           String correoElectronico,
                           String password,
                           Integer edad,
                           Long telefono,
                           String sexo,
                           Date fechaDeNacimiento,
                           String especialidad,
                           Integer añosDeExperiencia,
                           String horarioDeAtencion) {
}
