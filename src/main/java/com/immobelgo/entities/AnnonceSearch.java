package com.immobelgo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(	name = "sous_type_habitation")
@Data
public class AnnonceSearch {

    @SequenceGenerator(
            name = "searchannonce_sequence",
            sequenceName = "searchannonce_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "searchannonce_sequence"
    )
    private long id;

    @Column(name ="type_transaction")
    private String typeTransaction;
    @Column(name ="codepostal")
    private String communeOuCodePostal;
    @Column(name ="prix_min")
    private Long prixMin;
    @Column(name ="prix_max")
    private Long prixMax;
    @Column(name ="type_habitation")
    private String typeHabitation;
    @Column(name ="sous_type_habitation")
    private String sousTypeHabitation;
    @Column(name ="surface_min_terrain")
    private Long surfaceMinTerrain;
    @Column(name ="surface_max_terrain")
    private Long surfaceMaxTerrain;
    @Column(name ="surface_min_habitable")
    private Long surfaceMinHabitable;
    @Column(name ="surface_max_habitable")
    private Long surfaceMaxHabitable;
    @Column(name ="nbr_min_chambre")
    private Long nbrMinChambre;
    @Column(name ="nbr_max_chambre")
    private Long nbrMaxChambre;
    @Column(name ="accessible_handicape")
    private Boolean accessibleHandicape;
    @Column(name ="annee_construction")
    private Long anneeConstruction;
    @Column(name ="classe_energetique")
    private String classeEnergetique;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Users user;
}
