package com.immobelgo.repository;

import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Exterieur;
import com.immobelgo.entities.Interieur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterieurRepository extends JpaRepository<Interieur,Long> {

    Optional<Interieur> findByAnnonce(Annonce annonce);

}
