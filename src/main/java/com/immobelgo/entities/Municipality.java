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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(	name = "municipality")
@Data
public class Municipality {

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
    @Column(name="municipality_id")
    private long municipalityId;

    @Column(name="municipality_name_de")
    private String municipalityNameDe;

    @Column(name="municipality_name_fr")
    private String municipalityNameFr;

    @Column(name="municipality_name_nl")
    private String municipalityNameNl;

    @Column(name="postcode")
    private String postCode;

    @Column(name="postname_fr")
    private String postNameFr;

    @Column(name="postname_nl")
    private String postNameNl;

    @Column(name="region_code")
    private String regionCode;

}

