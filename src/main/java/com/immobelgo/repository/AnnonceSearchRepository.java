package com.immobelgo.repository;

import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.AnnonceSearch;
import com.immobelgo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnnonceSearchRepository extends JpaRepository<AnnonceSearch,Long> {

    List<AnnonceSearch> findAllByUser(Users user);
    Optional<AnnonceSearch> findById(Long id);

}
