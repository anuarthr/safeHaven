package com.data.safehaven.controllers;


import com.data.safehaven.dtos.RolDto;
import com.data.safehaven.services.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<RolDto> findAll() {
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDto> obtenerPacienteById(@PathVariable("id") Long id) {
        return rolService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RolDto> saveRol(@RequestBody RolDto rol) {
        return createRol(rol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RolDto> eliminarRol(@PathVariable("id") Long id) {
        return rolService.findById(id)
                .map(p -> {
                    rolService.deleteRol(id);
                    return ResponseEntity.ok().body(p);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDto> actualizarPaciente(@PathVariable("id") Long id, @RequestBody RolDto rol) {
        Optional<RolDto> rolUpdate = rolService.updateRol(id, rol);
        return rolUpdate
                .map(ResponseEntity::ok)
                .orElseGet(() -> createRol(rol));
    }

    private ResponseEntity<RolDto> createRol(RolDto rol) {
        RolDto newRol = rolService.saveRol(rol);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newRol.id()).toUri();
        return ResponseEntity.created(location).body(newRol);
    }
}
