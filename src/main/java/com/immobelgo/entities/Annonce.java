package com.immobelgo.entities;

import com.immobelgo.entities.enume.EtatBatimentEnum;
import com.immobelgo.entities.enume.TypeTransaction;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(	name = "annonce")
@Data
public class Annonce {

    @SequenceGenerator(
            name = "annonce_sequence",
            sequenceName = "annonce_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "annonce_sequence"
    )
    private long id;
    @Column(name="nbr_facade")
    private Integer nbrFacade;
    @Column(name="largeur_facade")
    private Long largeurFacade;
    @Column(name="surface_habitable")
    private Long surfaceHabitable;
    @Column(name="surface_terrain")
    private Long surfaceTerrain;

    @Column(name="nbr_chambre")
    private Long nbrChambre;

    @Column(name="nbr_etage")
    private Integer nbrEtage;

    @Column(name="annee_construction")
    private String anneeConstruction;

    @Column(name="etat_batiment")
    @Enumerated(EnumType.STRING)
    private EtatBatimentEnum etatBatiment;

    @Column(name="ascenseur")
    private Boolean ascenseur;

    @Column(name="acces_handicape")
    private Boolean accesHandicape;

    @Column(name="meuble")
    private Boolean meuble;

    @Column(name="gardien")
    private Boolean gardien;

    @Column(name="parking")
    private Boolean parking;

    @Column(name="nbr_place_parking")
    private Integer nbrPlaceParking;

    @Column(name="concierge")
    private Boolean concierge;
    @Column(name="disponibilite")
    private String disponibilite;
    @Column(name="type_bien")
    private String typeBien;
    @Column(name="sous_type_bien")
    private String sousTypeBien;

    @Column(name="titre_FR")
    private String titreFr;
    @Column(name="description_FR")
    private String descriptionFr;
    @Column(name="titre_Nl")
    private String titreNl;
    @Column(name="description_NL")
    private String descriptionNl;

    @Column(name="type_transaction")
    private String typeTransaction;
    //@Enumerated(EnumType.STRING)
    //private TypeTransaction typeTransaction;

    @ManyToOne
    @JoinColumn(name="id_adresse", nullable=false)
    private Adresse adresse;
    @Column(name="codepostal")
    private String codePostal;
    @Column(name="commune")
    private String commune;
    @Column(name="prix")
    private Long prix;
    @Column(name="photo_presentation")
    private byte[] photoPresentation;
    @Column(name ="code_annonce")
    private String codeAnnonce;
    @Column(name ="date_creation")
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Users user;

    
    /*id_type_environnement  	bigint,
    id_type_habitation  	bigint,*/



}
