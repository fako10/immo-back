CREATE TABLE searchannonce
(
    id               		BIGINT primary key,
    type_transaction		varchar(25),
    codepostal				varchar(25),
    prix_min      			bigint,
    prixMax					bigint,
    type_habitation			varchar(25),
    sous_type_habitation    varchar(25),
    surface_min_terrain     bigint,
    surface_max_terrain		bigint,
    surface_min_habitable  	bigint,
    surface_max_habitable  	bigint,
    nbr_min_chambre		  	bigint,
    nbr_max_chambre			bigint,
    accessible_handicape	boolean,
    annee_construction		bigint,
    classe_energetique		varchar(10),
    user_id					bigint,
    FOREIGN KEY(user_id) REFERENCES users(id)
);
CREATE SEQUENCE searchannonce_sequence START 1;