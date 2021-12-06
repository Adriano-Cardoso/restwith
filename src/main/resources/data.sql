alter table tb_user_profile add constraint uk_tb_user_profile_profile_id unique(profile_id);

alter table tb_user_profile add constraint fk_tb_user_profile_profile_id unique(profile_id);

alter table tb_user_profile add constraint fk_tb_user_profile_user_id foreign key (user_id) references tb_user;

alter table tb_person add foreign key(book_id) references tb_book(book_id);

INSERT INTO TB_USER(user_name, email, password) VALUES('admin', 'admin@email.com', '$2a$10$ScxWIRKjc4MAX4czBWFC1.A2BjxMdflbo3dgMmqdY8a.MirR2OPVS');

insert into tb_profile values(1,'ADMIN');

insert into tb_profile values(2,'USER');

insert into tb_user_profile values(1,1);


insert into tb_book(author, launch_date, price, title) values('Primo pobre', '2019-06-06', 10.00, 'ficando rico');

insert into tb_person(first_name, last_name, cpf, address, gender, book_id ) values ('joao pereira', 'jose Maria', '12345678911', 'Rua sem nome', 'M', 1);
