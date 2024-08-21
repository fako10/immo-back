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
@Table(	name = "photo")
@Data
public class Photo {

    @SequenceGenerator(
            name = "photo_sequence",
            sequenceName = "photo_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "photo_sequence"
    )
    private long id;
    @ManyToOne
    @JoinColumn(name="id_annonce", nullable=false)
    private Annonce annonce;
    @Column(name = "byte_photo", length = 1000)
    private byte[] bytePhoto;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "code_annonce")
    private String codeAnnonce;
}
