drop table if exists utilisateur;
drop table if exists type_habitation;
drop table if exists annonce_light;
drop table if exists photo;
drop table if exists adresse;
drop table if exists annonce;
drop table if exists annonce_light;
drop table if exists exterieur;
drop table if exists performance_energetique;
drop table if exists prescription_urbanistique;


CREATE TABLE adresse
(
    id               	BIGINT primary key,
    numero_boite		bigint,
    rue      			VARCHAR(255),
    numero_maison   	BIGINT,
    id_commune			bigint,
    nom_commune_FR		VARCHAR(255),
    nom_commune_NL		VARCHAR(255),
    codepostal			VARCHAR(255),
    postname_FR			VARCHAR(255),
    postname_NL			VARCHAR(255),
    id_ville			bigint,
    nom_ville_FR		VARCHAR(255),
    nom_ville_NL		VARCHAR(255),
    nom_ville_DE		VARCHAR(255),
    region				VARCHAR(255)

);

CREATE TABLE type_cuisine
(
    id               	BIGINT primary key,
    libelle      		VARCHAR(255 ),
    description			VARCHAR(255 )
);


CREATE TABLE type_habitation
(
    id               	BIGINT primary key,
    libelle      		VARCHAR(255),
    description			VARCHAR(255)
);

CREATE TABLE sous_type_habitation
(
    id               	BIGINT primary key,
    libelle      		VARCHAR(255),
    description			VARCHAR(255),
    id_type_habitation  bigint,
    FOREIGN KEY(id_type_habitation) REFERENCES type_habitation(id)
);

create table etat_batiment
(
    id               	BIGINT primary key,
    libelle      		VARCHAR(255),
    description			VARCHAR(255)
);



create table type_environnement
(
    id               	BIGINT primary key,
    libelle      		VARCHAR(255 ),
    description			VARCHAR(255 )
);

create table type_chauffage
(
    id               	BIGINT primary key,
    libelle      		VARCHAR(255),
    description			VARCHAR(255)
);


CREATE TABLE users
(
    id bigint primary key,
    role VARCHAR(255 ),
    email VARCHAR(255 ),
    enabled boolean NOT NULL  ,
    locked boolean NOT NULL,
    name VARCHAR(255 ),
    password VARCHAR(255 ),
    username VARCHAR(255 )
);

CREATE TABLE annonce
(
    id               		BIGINT primary key,
    nbr_facade      		bigint,
    largeur_facade			bigint,
    surface_habitable      	bigint,
    surface_terrain      	bigint,
    nbr_etage				bigint,
    annee_construction  	bigint,
    id_etat_batiment       	bigint,
    id_type_habitation  	bigint,
    ascenseur				boolean,
    acces_handicape			boolean,
    meuble					boolean,
    gardien					boolean,
    nbr_place_parking   	bigint,
    concierge				boolean,
    disponibilite			VARCHAR(255),
    id_type_environnement  	bigint,
    titre_FR            	varchar(255),
    description_FR			VARCHAR(255),
    titre_NL				VARCHAR(255),
    description_NL			VARCHAR(255),
    id_adresse				bigint,
    codepostal				bigint,
    commune					VARCHAR(255),
    photo_presentation		bytea,
    nbr_chambre			    BIGINT,
    prix					bigint,
    FOREIGN KEY(id_type_habitation) REFERENCES type_habitation(id),
    FOREIGN KEY(id_type_environnement) REFERENCES type_environnement(id),
    FOREIGN KEY(id_etat_batiment) REFERENCES etat_batiment(id),
    FOREIGN KEY(id_adresse) REFERENCES adresse(id)
);


create table photo
(
    id               	BIGINT primary key,
    id_annonce      	BIGINT,
    byte_photo			bytea,
    FOREIGN KEY(id_annonce) REFERENCES annonce(id)
);

create table interieur
(
    id               	BIGINT primary key,
    id_annonce      	BIGINT,
    nbr_chambre			BIGINT,
    nbr_pieces			BIGINT,
    nbr_salle_bain		BIGINT,
    nbr_toilette		BIGINT,
    --config_cuisine		VARCHAR(255),
    --id_type_cuisine		BIGINT,
    --FOREIGN KEY(id_type_cuisine) REFERENCES type_cuisine(id),
    FOREIGN KEY(id_annonce) REFERENCES annonce(id)
);


create table exterieur
(
    id               	BIGINT primary key,
    id_annonce      	BIGINT,
    jardin      		BOOLEAN,
    superficie_jardin	bigint,
    piscine				BOOLEAN,
    superficie_piscine	bigint,
    terrasse			BOOLEAN,
    superficie_terrasse	bigint,
    vue_sur_mer			BOOLEAN,
    FOREIGN KEY(id_annonce) REFERENCES annonce(id)
);

create table performance_energetique
(
    id               					BIGINT primary key,
    id_annonce      					BIGINT,
    id_type_chauffage      				BIGINT,
    classe_energetique					VARCHAR(10),
    numero_reference_CPEB				VARCHAR(25),
    PEB_consommation 					bigint,
    PEB_emission						bigint,
    description_CPEB_NL					VARCHAR(255),
    description_CPEB_FR					VARCHAR(255),
    conformite_electrique	            boolean,
    conformite_mazout					boolean,
    pompe_chaleur						BOOLEAN,
    panneaux_solaire					BOOLEAN,
    panneaux_photovoltaique				BOOLEAN,
    double_vitrage						BOOLEAN,
    triple_vitrage						BOOLEAN,
    chauffe_eau_commun					BOOLEAN,
    climatisation						BOOLEAN,
        FOREIGN KEY(id_annonce) REFERENCES annonce(id),
    FOREIGN KEY(id_type_chauffage) REFERENCES type_chauffage(id)
);

CREATE SEQUENCE adresse_sequence START 1;
CREATE SEQUENCE users_sequence START 1;
CREATE SEQUENCE type_cuisine_sequence START 1;
CREATE SEQUENCE type_habitation_sequence START 1;
CREATE SEQUENCE etat_batiment_sequence START 1;
CREATE SEQUENCE type_environnement_sequence START 1;
CREATE SEQUENCE type_chauffage_sequence START 1;
CREATE SEQUENCE annonce_sequence START 1;
CREATE SEQUENCE interieur_sequence START 1;
CREATE SEQUENCE exterieur_sequence START 1;
CREATE SEQUENCE performance_energetique_sequence START 1;