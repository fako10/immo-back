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
@Table(	name = "exterieur")
@Data
public class Exterieur {

    @SequenceGenerator(
            name = "interieur_sequence",
            sequenceName = "interieur_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "interieur_sequence"
    )
    private long id;
    @ManyToOne
    @JoinColumn(name="id_annonce", nullable=false)
    private Annonce annonce;

    @Column(name = "jardin")
    private Boolean jardin;
    @Column(name = "superficie_jardin")
    private long superficieJardin;

    @Column(name = "piscine")
    private Boolean piscine;
    @Column(name = "superficie_piscine")
    private long superficiePiscine;
    @Column(name = "terrasse")
    private Boolean terrasse;
    @Column(name = "superficie_terrasse")
    private Long superficieTerrasse;
    @Column(name = "vue_sur_mer")
    private Boolean vueSurMer;

}
