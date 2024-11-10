package com.data.safehaven.controllers;

import com.data.safehaven.dtos.PsicologoDto;
import com.data.safehaven.services.PsicologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/psicologos")
@CrossOrigin("http://localhost:5173/")
public class PsicologoController {
    private final PsicologoService psicologoService;

    public PsicologoController(PsicologoService psicologoService) {
        this.psicologoService = psicologoService;
    }

    @GetMapping
    ResponseEntity<List<PsicologoDto>> obtenerPsicologos() {
        return ResponseEntity.ok(psicologoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PsicologoDto> obtenerPsicologoById(@PathVariable("id") Long id) {
        return psicologoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PsicologoDto> crearPsicologo(@RequestBody PsicologoDto psicologo) {
        return createPsicologo(psicologo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PsicologoDto> eliminarPsicologo(@PathVariable("id") Long id) {
        return psicologoService.findById(id)
                .map(p -> {
                    psicologoService.deletePsicologo(id);
                    return ResponseEntity.ok().body(p);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PsicologoDto> actualizarPsicologo(@PathVariable("id") Long id, @RequestBody PsicologoDto psicologo) {
        Optional<PsicologoDto> psicologoUpdate = psicologoService.updatePsicologo(id, psicologo);
        return psicologoUpdate
                .map(ResponseEntity::ok)
                .orElseGet(() -> createPsicologo(psicologo));
    }

    private ResponseEntity<PsicologoDto> createPsicologo(PsicologoDto psicologo) {
        PsicologoDto newPsicologo = psicologoService.savePsicologo(psicologo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newPsicologo.id()).toUri();
        return ResponseEntity.created(location).body(newPsicologo);
    }
}
