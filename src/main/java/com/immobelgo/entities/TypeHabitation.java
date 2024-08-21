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
import javax.persistence.UniqueConstraint;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(	name = "type_habitation")
@Data
public class TypeHabitation {

    @SequenceGenerator(
            name = "type_habitation_sequence",
            sequenceName = "type_habitation_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "type_habitation_sequence"
    )
    private long id;
    @Column(name="libelle")
    private String libelle;
    @Column(name="description")
    private String description;

}
