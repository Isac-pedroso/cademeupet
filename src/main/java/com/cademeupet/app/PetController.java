package com.cademeupet.app;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cademeupet.app.Pet;
import com.cademeupet.app.PetService;

@RestController
@RequestMapping("/pets")
@CrossOrigin("*")
public class PetController {

    private final PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Pet> salvar(
            @RequestBody Pet pet) {

        return ResponseEntity.ok(
                service.salvar(pet)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> atualizar(
            @PathVariable Long id,
            @RequestBody Pet pet) {

        return ResponseEntity.ok(
                service.atualizar(id, pet)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}