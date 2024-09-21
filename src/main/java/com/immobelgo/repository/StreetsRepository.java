package com.immobelgo.repository;

import com.immobelgo.entities.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetsRepository extends JpaRepository<Street, Long> {

    List<Street> findAllByMunicipalityId(long municipalityId);

}
