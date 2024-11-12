package com.data.safehaven.controllers;

import com.data.safehaven.dtos.ConsultorioDto;
import com.data.safehaven.services.ConsultorioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/consultorios")
@CrossOrigin("http://localhost:5173/")
public class ConsultorioController {
    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @GetMapping
    ResponseEntity<List<ConsultorioDto>> obtenerConsultorios() {
        return ResponseEntity.ok(consultorioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultorioDto> obtenerConsultorioById(@PathVariable("id") Long id) {
        return consultorioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConsultorioDto> crearConsultorio(@RequestBody ConsultorioDto consultorio) {
        return createConsultorio(consultorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConsultorioDto> eliminarConsultorio(@PathVariable("id") Long id) {
        return consultorioService.findById(id)
                .map(p -> {
                    consultorioService.deleteConsultorio(id);
                    return ResponseEntity.ok().body(p);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultorioDto> actualizarConsultorio(@PathVariable("id") Long id, @RequestBody ConsultorioDto consultorio) {
        Optional<ConsultorioDto> consultorioUpdate = consultorioService.updateConsultorio(id, consultorio);
        return consultorioUpdate
                .map(ResponseEntity::ok)
                .orElseGet(() -> createConsultorio(consultorio));
    }

    private ResponseEntity<ConsultorioDto> createConsultorio(ConsultorioDto consultorio) {
        ConsultorioDto newConsultorio = consultorioService.saveConsultorio(consultorio);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newConsultorio.id()).toUri();
        return ResponseEntity.created(location).body(newConsultorio);
    }
}
