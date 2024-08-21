package com.immobelgo.repository;

import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Interieur;
import com.immobelgo.entities.Prix;
import com.immobelgo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrixRepository extends JpaRepository<Prix, Long> {

    Optional<Prix> findByAnnonce(Annonce annonce);
}
