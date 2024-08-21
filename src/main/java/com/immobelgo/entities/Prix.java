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
@Table(	name = "prixvente")
@Data
public class Prix {

    @SequenceGenerator(
            name = "prix_sequence",
            sequenceName = "prix_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "prix_sequence"
    )
    private long id;
    @ManyToOne
    @JoinColumn(name="id_annonce", nullable=false)
    private Annonce annonce;
    @Column(name = "prix")
    private Long prix;

    @Column(name = "revenu_cadastre")
    private Long revenuCadastre;
    @Column(name = "tva")
    private Long tva;
    @Column(name = "charges")
    private Long charges;
    @Column(name = "prix_metre_carre")
    private Long prixMetreCarre;
}




