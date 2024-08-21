package com.immobelgo.repository;

import com.immobelgo.entities.Adresse;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdresseRepository extends JpaRepository<Adresse,Long>  {

    List<Adresse> findAll(Specification<Adresse> specification);
    Optional<Adresse> findById(Long id);

}
