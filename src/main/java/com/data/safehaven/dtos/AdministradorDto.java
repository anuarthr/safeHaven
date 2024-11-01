package com.data.safehaven.dtos;

import com.data.safehaven.entities.Rol;

import java.util.Date;

public record AdministradorDto(Long id,
                               String nombre,
                               String apellido,
                               Rol rol,
                               String correoElectronico,
                               String password,
                               Integer edad,
                               Integer telefono,
                               String sexo,
                               Date fechaDeNacimiento,
                               String cargo) {
}
