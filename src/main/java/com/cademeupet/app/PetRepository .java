package com.petfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petfinder.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}