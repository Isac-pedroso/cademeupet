

package com.cademeupet.app;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cademeupet.app.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}