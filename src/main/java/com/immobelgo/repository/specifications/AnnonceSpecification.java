package com.immobelgo.repository.specifications;

import com.immobelgo.dto.AnnonceSearchDto;
import com.immobelgo.entities.Annonce;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AnnonceSpecification {

    public static Specification<Annonce> filterAnnonce(AnnonceSearchDto annonceSearchDto) {

        /*private String typeTransaction;
        private String communeOuCodePostal;
        private long prixMin;
        private long prixMax;
        private String typeHabitation;
        private String sousTypeHabitation;
        private Long surfaceTerrain;
        private Long nbrMinChambre;
        private Long nbrMaxChambre;
        private Boolean accessibleHandicape;
        private Long anneeConstruction;
        private String classeEnergetique;*/

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(annonceSearchDto.getNbrMinChambre() != null) {
                Predicate minChambrePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("nbrChambre"),
                        annonceSearchDto.getNbrMinChambre());
                predicates.add(minChambrePredicate);
            }
            if(annonceSearchDto.getNbrMaxChambre() != null) {
                Predicate maxChambrePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("nbrChambre"),
                        annonceSearchDto.getNbrMaxChambre());
                predicates.add(maxChambrePredicate);
            }
            if(annonceSearchDto.getTypeTransaction() != null) {
                Predicate typeTransactionPredicate = criteriaBuilder.like(root.get("typeTransaction"),
                        annonceSearchDto.getTypeTransaction());
                predicates.add(typeTransactionPredicate);
            }
            if(annonceSearchDto.getCommuneOuCodePostal() != null && !annonceSearchDto.getCommuneOuCodePostal().isEmpty()) {
                if(StringUtils.isNumeric(annonceSearchDto.getCommuneOuCodePostal())) {
                    Predicate codePostalPredicate = criteriaBuilder.like(root.get("codePostal"),
                            annonceSearchDto.getCommuneOuCodePostal());
                    predicates.add(codePostalPredicate);
                }
                if(!StringUtils.isNumeric(annonceSearchDto.getCommuneOuCodePostal())) {
                    Predicate codePostalPredicate = criteriaBuilder.like(root.get("commune"),
                            annonceSearchDto.getCommuneOuCodePostal());
                    predicates.add(codePostalPredicate);
                }
            }
            if(annonceSearchDto.getPrixMin() != null ) {
                Predicate prixMinPredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("prix"),
                        annonceSearchDto.getPrixMin());
                predicates.add(prixMinPredicate);
            }
            if(annonceSearchDto.getPrixMax() != null && annonceSearchDto.getPrixMax() > 0) {
                Predicate prixMinPredicate = criteriaBuilder.lessThanOrEqualTo(root.get("prix"),
                        annonceSearchDto.getPrixMax());
                predicates.add(prixMinPredicate);
            }
            if(annonceSearchDto.getTypeHabitation() != null) {
                Predicate typeHabitationPredicate = criteriaBuilder.like(root.get("typeBien"),
                        annonceSearchDto.getTypeHabitation());
                predicates.add(typeHabitationPredicate);
            }
            if(annonceSearchDto.getSousTypeHabitation() != null) {
                Predicate sousTypeHabitationPredicate = criteriaBuilder.like(root.get("sousTypeHabitation"),
                        annonceSearchDto.getSousTypeHabitation());
                predicates.add(sousTypeHabitationPredicate);
            }
            if(annonceSearchDto.getSurfaceMinTerrain() != null) {
                Predicate surfaceMinTerrainPredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("surfaceTerrain"),
                        annonceSearchDto.getSurfaceMinTerrain());
                predicates.add(surfaceMinTerrainPredicate);
            }
            if(annonceSearchDto.getSurfaceMaxTerrain() != null) {
                Predicate surfaceMinTerrainPredicate = criteriaBuilder.lessThanOrEqualTo(root.get("surfaceTerrain"),
                        annonceSearchDto.getSurfaceMaxTerrain());
                predicates.add(surfaceMinTerrainPredicate);
            }

            if(annonceSearchDto.getSurfaceMinHabitable() != null) {
                Predicate surfaceMinHabitatblePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("surfaceHabitable"),
                        annonceSearchDto.getSurfaceMinHabitable());
                predicates.add(surfaceMinHabitatblePredicate);
            }
            if(annonceSearchDto.getSurfaceMaxTerrain() != null) {
                Predicate surfaceMaxHabitatblePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("surfaceHabitable"),
                        annonceSearchDto.getSurfaceMaxTerrain());
                predicates.add(surfaceMaxHabitatblePredicate);
            }



            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };

    }

    private void addEqualPredicates(List<Predicate> predicates,
                                    CriteriaBuilder criteriaBuilder,
                                    String valeur,
                                    String colonne,
                                    Root<Annonce> root) {
        Predicate predicate = criteriaBuilder.equal(root.get(colonne), valeur);
        predicates.add(predicate);
    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }



    }

