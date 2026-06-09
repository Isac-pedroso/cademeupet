package com.cademeupet.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cademeupet.app.Pet;
import com.cademeupet.app.PetRepository;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public List<Pet> listarTodos() {
        return repository.findAll();
    }

    public Pet buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pet não encontrado"));
    }

    public Pet salvar(Pet pet) {
        return repository.save(pet);
    }

    public Pet atualizar(Long id, Pet pet) {

        Pet petExistente = buscarPorId(id);

        petExistente.setNome(pet.getNome());
        petExistente.setEspecie(pet.getEspecie());
        petExistente.setContato(pet.getContato());
        petExistente.setLatitude(pet.getLatitude());
        petExistente.setLongitude(pet.getLongitude());
        petExistente.setPerdido(pet.getPerdido());

        return repository.save(petExistente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}