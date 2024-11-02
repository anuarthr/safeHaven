package com.data.safehaven.controllers;

import com.data.safehaven.dtos.AdministradorDto;
import com.data.safehaven.services.AdministradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {
    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    ResponseEntity<List<AdministradorDto>> obtenerAdministradores() {
        return ResponseEntity.ok(administradorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDto> obtenerAdministradorById(@PathVariable("id") Long id) {
        return administradorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdministradorDto> crearAdministrador(@RequestBody AdministradorDto administrador) {
        return createAdministrador(administrador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdministradorDto> eliminarAdministrador(@PathVariable("id") Long id) {
        return administradorService.findById(id)
                .map(p -> {
                    administradorService.deleteAdministrador(id);
                    return ResponseEntity.ok().body(p);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorDto> actualizarAdministrador(@PathVariable("id") Long id, @RequestBody AdministradorDto administrador) {
        Optional<AdministradorDto> administradorUpdate = administradorService.updateAdministrador(id, administrador);
        return administradorUpdate
                .map(ResponseEntity::ok)
                .orElseGet(() -> createAdministrador(administrador));
    }

    private ResponseEntity<AdministradorDto> createAdministrador(AdministradorDto administrador) {
        AdministradorDto newAdministrador = administradorService.saveAdministrador(administrador);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newAdministrador.id()).toUri();
        return ResponseEntity.created(location).body(newAdministrador);
    }
}