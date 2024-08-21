alter table annonce drop column  id_etat_batiment;
alter table annonce add column etat_batiment varchar(30);
alter table annonce add column classe_energetique varchar(25);