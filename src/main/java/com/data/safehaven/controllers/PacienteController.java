package com.data.safehaven.controllers;

import com.data.safehaven.dtos.PacienteDto;
import com.data.safehaven.services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin("http://localhost:5173/")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    ResponseEntity<List<PacienteDto>> obtenerPacientes() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> obtenerPacienteById(@PathVariable("id") Long id) {
        return pacienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PacienteDto> crearPaciente(@RequestBody PacienteDto paciente) {
        return createPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteDto> eliminarPaciente(@PathVariable("id") Long id) {
        return pacienteService.findById(id)
                .map(p -> {
                    pacienteService.deletePaciente(id);
                    return ResponseEntity.ok().body(p);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDto> actualizarPaciente(@PathVariable("id") Long id, @RequestBody PacienteDto paciente) {
        Optional<PacienteDto> pacienteUpdate = pacienteService.updatePaciente(id, paciente);
        return pacienteUpdate
                .map(ResponseEntity::ok)
                .orElseGet(() -> createPaciente(paciente));
    }

    private ResponseEntity<PacienteDto> createPaciente(PacienteDto paciente) {
        PacienteDto newPaciente = pacienteService.savePaciente(paciente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPaciente.id()).toUri();
        return ResponseEntity.created(location).body(newPaciente);
    }
}