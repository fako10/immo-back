package com.immobelgo.repository.specifications;

import com.immobelgo.dto.AdresseDto;
import com.immobelgo.dto.AnnonceSearchDto;
import com.immobelgo.entities.Adresse;
import com.immobelgo.entities.Annonce;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class AdresseSpecification {

    public static Specification<Adresse> filterAdresse(AdresseDto adresseDto) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(adresseDto.getCodePostal() != null) {
                Predicate codePostalPredicate = criteriaBuilder.like(root.get("numero_maison"),
                        adresseDto.getNumero());
                predicates.add(codePostalPredicate);
            }
            if(adresseDto.getCommuneFr() != null) {
                Predicate communeFrPredicate = criteriaBuilder.like(root.get("nomcommunefr"),
                        adresseDto.getCommuneFr());
                predicates.add(communeFrPredicate);
            }
            if(adresseDto.getCommuneNl() != null) {
                Predicate communeNlPredicate = criteriaBuilder.like(root.get("nomcommunenl"),
                        adresseDto.getCommuneNl());
                predicates.add(communeNlPredicate);
            }
            if(adresseDto.getRue() != null) {
                Predicate ruePredicate = criteriaBuilder.like(root.get("rue"),
                        adresseDto.getRue());
                predicates.add(ruePredicate);
            }
            /*if(adresseDto.getNumero() != null ) {
                Predicate numeroMaisonPredicate = criteriaBuilder.like(root.get("numeromaison"),
                        adresseDto.getNumero());
                predicates.add(numeroMaisonPredicate);
            }
            if(adresseDto.getBoite() != null ) {
                Predicate numeroboiteMinPredicate = criteriaBuilder.like(root.get("numeroboite"),
                        adresseDto.getBoite());
                predicates.add(numeroboiteMinPredicate);
            }*/


            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
