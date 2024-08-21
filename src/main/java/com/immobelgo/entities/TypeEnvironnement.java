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
@Table(	name = "type_environnement")
@Data
public class TypeEnvironnement {

    @SequenceGenerator(
            name = "type_environnement_sequence",
            sequenceName = "type_environnement_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "type_environnement_sequence"
    )
    private long id;
    @Column(name="libelle")
    private String libelle;
    @Column(name="description")
    private String description;

}
