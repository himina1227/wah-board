insert into account (name, email, password, rang_king, activated) values ('admin', 'test@naver.com','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 0, 1);
insert into account (name, email, password, rang_king, activated) values ('user', 'test1@naver.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 0, 1);

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into account_authority (id, authority_name) values (1, 'ROLE_USER');
insert into account_authority (id, authority_name) values (1, 'ROLE_ADMIN');
insert into account_authority (id, authority_name) values (2, 'ROLE_USER');