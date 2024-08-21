alter table annonce add column code_annonce varchar(40);
alter table photo add column code_annonce varchar(40);
alter table photo drop column id_annonce;