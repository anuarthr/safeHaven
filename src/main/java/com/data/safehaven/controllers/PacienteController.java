package com.data.safehaven.controllers;

import com.data.safehaven.entities.Paciente;
import com.data.safehaven.services.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    ResponseEntity<List<Paciente>> obtenerPacientes() {
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacienteById(@PathVariable("id") Long id) {
        return pacienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        return createPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> eliminarPaciente(@PathVariable("id") Long id) {
        return pacienteService.findById(id)
                .map(p -> {
                    pacienteService.deletePaciente(id);
                    return ResponseEntity.ok().body(p);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable("id") Long id, @RequestBody Paciente paciente) {
        Optional<Paciente> pacienteUpdate = pacienteService.updatePaciente(id, paciente);
        return pacienteUpdate
                .map(ResponseEntity::ok)
                .orElseGet(() -> createPaciente(paciente));
    }

    private ResponseEntity<Paciente> createPaciente(Paciente paciente) {
        Paciente newPaciente = pacienteService.savePaciente(paciente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPaciente.getId()).toUri();
        return ResponseEntity.created(location).body(newPaciente);
    }
}