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
@Table(	name = "interieur")
@Data
public class Interieur {

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
    @Column(name="nbr_chambre")
    private Long nbrChambre;
    @Column(name="nbr_pieces")
    private Long nbrPiece;
    @Column(name="nbr_salle_bain")
    private Long nbrSalleBain;
    @Column(name="nbr_toilette")
    private Long nbrToilette;

}
