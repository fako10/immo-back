package com.immobelgo.entities;

import com.immobelgo.entities.enume.ClasseEnergetique;
import com.immobelgo.entities.enume.Typechauffage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(	name = "performance_energetique")
@Data
public class PerformanceEnergetique {

    @SequenceGenerator(
            name = "performance_energetique_sequence",
            sequenceName = "performance_energetique_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "performance_energetique_sequence"
    )
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name="type_chauffage")
    private Typechauffage typeChauffage;
    @ManyToOne
    @JoinColumn(name="id_annonce", nullable=false)
    private Annonce annonce;

    @Enumerated(EnumType.STRING)
    @Column(name = "classe_energetique")
    private ClasseEnergetique classeEnergetique;
    @Column(name = "numero_reference_CPEB")
    private String numeroReferenceCPEB;
    @Column(name = "PEB_consommation")
    private long consommationPEB;
    @Column(name = "PEB_emission")
    private long emissionPEB;
    @Column(name = "description_CPEB_NL")
    private String descriptionPebNL;
    @Column(name = "description_CPEB_FR")
    private String descriptionPebFR;

    @Column(name = "conformite_electrique")
    private Boolean conformiteELectrique;
    @Column(name = "conformite_mazout")
    private Boolean conformiteMazout;

    @Column(name = "pompe_chaleur")
    private Boolean pompeChaleur;
    @Column(name = "panneaux_solaire")
    private Boolean panneauxSolaire;
    @Column(name = "panneaux_photovoltaique")
    private Boolean panneauxPhotovoltaique;
    @Column(name = "double_vitrage")
    private Boolean doubleVitrage;
    @Column(name = "triple_vitrage")
    private Boolean tripleVitrage;
    @Column(name = "chauffe_eau_commun")
    private Boolean chauffeEauCommun;
    @Column(name = "climatisation")
    private Boolean climatisation;
}
