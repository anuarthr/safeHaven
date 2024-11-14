package com.data.safehaven.controllers;

import com.data.safehaven.dtos.LoginRequestDto;
import com.data.safehaven.dtos.UsuarioDto;
import com.data.safehaven.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:5173/")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> login(@RequestBody LoginRequestDto loginRequest) {
        Optional<UsuarioDto> usuarioOpt = usuarioService.findByCorreoElectronico(loginRequest.email());
        if (usuarioOpt.isPresent()) {
            UsuarioDto usuario = usuarioOpt.get();
            if (usuarioService.validatePassword(usuario, loginRequest.password())) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioDto> obtenerUsuarioLogueado(@RequestParam("email") String email) {
        Optional<UsuarioDto> usuarioOpt = usuarioService.findByCorreoElectronico(email);
        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok(usuarioOpt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
