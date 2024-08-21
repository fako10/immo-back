package com.immobelgo.repository;

import com.immobelgo.entities.Annonce;
import com.immobelgo.entities.Photo;
import com.immobelgo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface    PhotoRepository extends JpaRepository<Photo, Long>  {

    List<Photo> getAllByAnnonce(Annonce annonce);

}
