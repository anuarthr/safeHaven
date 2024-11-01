package com.data.safehaven.services;

import com.data.safehaven.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(long id);

    Optional<Usuario> findByNombre(String nombre);

    Usuario savePaciente(Usuario usuario);

    void deletePaciente(long id);

    Optional<Usuario> updatePaciente(long id, Usuario usuario);
}
