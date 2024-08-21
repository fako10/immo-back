package com.immobelgo.services;


import com.immobelgo.dto.AnnonceSearchDto;
import com.immobelgo.dto.mapper.AnnonceSearchMapper;
import com.immobelgo.entities.AnnonceSearch;
import com.immobelgo.entities.Users;
import com.immobelgo.repository.AnnonceSearchRepository;
import com.immobelgo.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnnonceSearchService {

    @Autowired
    private AnnonceSearchRepository annonceSearchRepository;

    UserDetailsServiceImpl userDetails;

    public AnnonceSearchDto getAnnonceSearchById(Long id) {
        AnnonceSearch annonceSearch = new AnnonceSearch();
        Optional<AnnonceSearch> optionalAnnonceSearch = annonceSearchRepository.findById(id);
        if(optionalAnnonceSearch.isPresent()) {
            annonceSearch = optionalAnnonceSearch.get();
        }
        return AnnonceSearchMapper.toDto(annonceSearch);
    }

    public List<AnnonceSearchDto> getAnnonceByUser() {
        Users user = userDetails.getConnectedUser();

        List<AnnonceSearch> annonceSearches = annonceSearchRepository.findAllByUser(user);
        return annonceSearches.stream().map(AnnonceSearchMapper::toDto).collect(Collectors.toList());
    }

    public AnnonceSearchDto saveAnnonceSearch(AnnonceSearchDto annonceSearchDto) {
        AnnonceSearch annonceSearch = AnnonceSearchMapper.toEntity(annonceSearchDto);
        annonceSearch = annonceSearchRepository.save(annonceSearch);
        return AnnonceSearchMapper.toDto(annonceSearch);
    }
}
