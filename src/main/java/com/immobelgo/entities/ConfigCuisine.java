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
@Table(	name = "config_cuisine")
@Data
public class ConfigCuisine {

    @SequenceGenerator(
            name = "config_cuisine_sequence",
            sequenceName = "config_cuisine_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "config_cuisine_sequence"
    )
    private long id;
    @Column(name="libelle")
    private long libelle;
    @Column(name="description")
    private String description;

}
