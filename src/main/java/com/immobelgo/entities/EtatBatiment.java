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
@Table(	name = "etat_batiment")
@Data
public class EtatBatiment {

    @SequenceGenerator(
            name = "etat_batiment_sequence",
            sequenceName = "etat_batiment_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "etat_batiment_sequence"
    )
    private long id;
    @Column(name="libelle")
    private String libelle;
    @Column(name="description")
    private String description;
}
