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
public class SousTypeHabitation {

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
    private Long id;
    @Column(name="libelle")
    private Long libelle;
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="id_type_habitation", nullable=false)
    private TypeHabitation typeHabitation;
}
