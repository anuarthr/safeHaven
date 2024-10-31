package com.data.safehaven.dtos;

import java.util.Date;

public record UsuarioDto(Long id, String nombre, String apellido,
                         String correoElectronico, String password,
                         Integer edad, Integer telefono, String sexo,
                         Date fechaDeNacimiento) {
}
