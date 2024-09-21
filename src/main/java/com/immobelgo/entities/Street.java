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
@Table(name = "openmunicipality")
public class Street {


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
    @Column(name="street_id")
    private long streetId;

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

    @Column(name="streetname_de")
    private String streetNameDe;

    @Column(name="streetname_fr")
    private String streetNameFr;

    @Column(name="streetname_nl")
    private String streetNameNl;

    @Column(name="region_code")
    private String regionCode;

}
