package com.immobelgo.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "adresse")
public class Adresse {

    @SequenceGenerator(
            name = "adresse_sequence",
            sequenceName = "adresse_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "adresse_sequence"
    )
    private long id;
    @Column(name="numero_boite")
    private Long numeroboite;
    @Column(name="rue")
    private String rue;
    @Column(name="rue_fr")
    private String rueFr;
    @Column(name="rue_nl")
    private String rueNl;
    @Column(name="pays")
    private String pays;
    @Column(name="numero_maison")
    private Long numeromaison;
    @Column(name="id_commune")
    private Long idcommune;
    @Column(name="nom_commune_FR")
    private String nomcommunefr;
    @Column(name="nom_commune_NL")
    private String nomcommunenl;
    @Column(name="codepostal")
    private String codepostal;
    @Column(name="postname_FR")
    private String postnamefr;
    @Column(name="postname_NL")
    private String postnamenl;
    @Column(name="id_ville")
    private Long idville;
    @Column(name="nom_ville_FR")
    private String nomvillefr;
    @Column(name="nom_ville_NL")
    private String nomvillenl;
    @Column(name="nom_ville_DE")
    private String nomvillede;
    @Column(name="region")
    private String region;

}
