package com.data.safehaven.controllers;

import com.data.safehaven.dtos.CitaDto;
import com.data.safehaven.services.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin("http://localhost:5173/")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    ResponseEntity<List<CitaDto>> obtenerCitas() {
        return ResponseEntity.ok(citaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDto> obtenerCitaById(@PathVariable("id") Long id) {
        return citaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CitaDto> crearCita(@RequestBody CitaDto cita) {
        return createCita(cita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CitaDto> eliminarCita(@PathVariable("id") Long id) {
        return citaService.findById(id)
                .map(p -> {
                    citaService.deleteCita(id);
                    return ResponseEntity.ok().body(p);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDto> actualizarCita(@PathVariable("id") Long id, @RequestBody CitaDto cita) {
        Optional<CitaDto> citaUpdate = citaService.updateCita(id, cita);
        return citaUpdate
                .map(ResponseEntity::ok)
                .orElseGet(() -> createCita(cita));
    }

    private ResponseEntity<CitaDto> createCita(CitaDto cita) {
        CitaDto newCita = citaService.saveCita(cita);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newCita.id()).toUri();
        return ResponseEntity.created(location).body(newCita);
    }
}
