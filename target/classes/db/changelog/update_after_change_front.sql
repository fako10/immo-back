alter table adresse add column rue_fr varchar(250);
alter table adresse add column rue_nl varchar(250);
alter table adresse add column pays varchar(250);
alter table annonce add column parking boolean;
alter table annonce add column type_bien varchar(250);
alter table annonce add column sous_type_bien varchar(250);

drop table if exists prixvente;


CREATE TABLE prixvente
(
    id               	BIGINT primary key,
    prix      		    BIGINT,
    revenu_cadastre		BIGINT,
    tva                 float,
    charges             BIGINT,
    prix_metre_carre    BIGINT
);

CREATE TABLE titreetdesription
(
    id              	BIGINT primary key,
    titre_fr      		VARCHAR(255),
    description_fr		VARCHAR(255),
    titre_nl            VARCHAR(255),
    description_nl      VARCHAR(255),
    titre_en            VARCHAR(255),
    description_en      VARCHAR(255)
);


CREATE SEQUENCE prixvente_sequence START 1;
CREATE SEQUENCE titreetdesription_sequence START 1;