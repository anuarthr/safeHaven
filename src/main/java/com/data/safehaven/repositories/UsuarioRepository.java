package com.data.safehaven.repositories;

import com.data.safehaven.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoElectronico(String email);
    Optional<Usuario> findByNombre(String nombre);
    Optional<Usuario> findByApellido(String apellido);


}
