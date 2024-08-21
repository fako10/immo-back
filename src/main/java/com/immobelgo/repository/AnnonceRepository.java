package com.immobelgo.repository;

import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Users;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnnonceRepository extends PagingAndSortingRepository<Annonce,Long>, JpaSpecificationExecutor<Annonce> {

    List<Annonce> findAll(Specification<Annonce> specification);
    Optional<Annonce> findByCodeAnnonce(String code);
    List<Annonce> findAllByUser(Users user);
}
