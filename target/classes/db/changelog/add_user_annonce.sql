alter table annonce add column  user_id bigint;
ALTER TABLE annonce ADD FOREIGN KEY (user_id) REFERENCES Users(id);