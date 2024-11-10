package com.data.safehaven.controllers;

import com.data.safehaven.dtos.LoginRequestDto;
import com.data.safehaven.dtos.PacienteDto;
import com.data.safehaven.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:5173/")
public class AuthController {

    private final PacienteService pacienteService;

    public AuthController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest) {
        Optional<PacienteDto> pacienteOpt = pacienteService.findByCorreoElectronico(loginRequest.email());
        if (pacienteOpt.isPresent()) {
            PacienteDto paciente = pacienteOpt.get();

            if (pacienteService.validatePassword(paciente, loginRequest.password())) {
                return ResponseEntity.ok("Login exitoso");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
    }
}
