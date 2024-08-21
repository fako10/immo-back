package com.immobelgo.repository;

import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.PerformanceEnergetique;
import com.immobelgo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerformanceEnergetiqueRepository extends JpaRepository<PerformanceEnergetique,Long> {

    Optional<PerformanceEnergetique> findByAnnonce(Annonce annonce);
}
