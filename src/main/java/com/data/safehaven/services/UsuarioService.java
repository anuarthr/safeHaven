package com.data.safehaven.services;

import com.data.safehaven.dtos.PacienteDto;
import com.data.safehaven.dtos.UsuarioDto;

import com.data.safehaven.dtos.UsuarioMapper;
import com.data.safehaven.entities.Usuario;
import com.data.safehaven.entities.Usuario;
import com.data.safehaven.repositories.UsuarioRepository;
import com.data.safehaven.repositories.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;
    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;

        this.rolRepository = rolRepository;
        this.usuarioMapper = usuarioMapper;
    }
    public Optional<UsuarioDto> findByCorreoElectronico(String email) {
        return usuarioRepository.findByCorreoElectronico(email).map(usuarioMapper::toDTO);
    }

    public boolean validatePassword(UsuarioDto usuario, String password) {
        return usuario.password().equals(password);
    }
}
