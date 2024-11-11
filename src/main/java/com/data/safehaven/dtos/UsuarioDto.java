package com.data.safehaven.dtos;

import java.util.Date;

public record UsuarioDto(Long id,
                         String nombre,
                         String apellido,
                         Long rol,
                         String correoElectronico,
                         String password,
                         Integer edad,
                         Long telefono,
                         String sexo,
                         Date fechaDeNacimiento) {
}
