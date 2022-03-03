create database gerador_prova;

create type tipo_questao as enum ('ABERTA', 'ESCOLHA_UNICA', 'ESCOLHA_MULTIPLA');
create type dificuldade as enum ('FACIL', 'MEDIO', 'DIFICIL');

create table tb_prova(
	id_prova serial not null primary key,
	titulo varchar(100) not null,
	finalizada int default 0,
	corrigida int default 0,
	nota decimal(5,2)
);

create table tb_tag(
	id_tag serial not null primary key,
	nome varchar(30) not null
);

create table tb_questao(
	id_questao serial not null primary key,
	enunciado varchar(100) not null,
	tipo_questao tipo_questao not null,
	dificuldade dificuldade not null,
	id_tag int4 not null,
	constraint fk_questao_tag foreign key(id_tag) references tb_tag(id_tag)
);


create table tb_resposta(
	id_resposta serial not null primary key,
	resposta varchar(150),
	resposta_correta int default 0,
	id_questao int4 not null,
	constraint fk_resposta_questao foreign key(id_questao) references tb_questao(id_questao) 
);


create table tb_questao_historico(
	id_questao_historico serial not null primary key,
	enunciado varchar(100) not null,
	tipo_questao tipo_questao not null,
	dificuldade dificuldade not null,
	tag varchar(30) not null,
	id_prova int4 not null,
	constraint fk_questao_historico_prova foreign key(id_prova) references tb_prova(id_prova)
);

create table tb_resposta_historico(
	id_resposta_historico serial not null primary key,
	resposta varchar(150),
	resposta_correta int default 0,
	selecionado int default 0,
	id_questao_historico int4 not null,
	constraint fk_resposta_historico_questao foreign key(id_questao_historico) references tb_questao_historico(id_questao_historico) 
);





insert into tb_tag (id_tag, nome) values (1, 'redes');

insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (1, 'questao01', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (2, 'questao02', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (3, 'questao03', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (4, 'questao04', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (5, 'questao05', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (6, 'questao06', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (7, 'questao07', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (8, 'questao08', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (9, 'questao09', 'ESCOLHA_UNICA', 'FACIL', 1);
insert into tb_questao (id_questao, enunciado, "tipo_questao", dificuldade, id_tag) values (10, 'questao10', 'ESCOLHA_UNICA', 'FACIL', 1);



insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (1, 'Alternativa01', 0, 1);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (2, 'Alternativa02', 0, 1);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (3, 'Alternativa03', 0, 1);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (4, 'Alternativa04', 0, 1);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (5, 'Alternativa05', 1, 1);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (6, 'Alternativa01', 0, 2);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (7, 'Alternativa02', 0, 2);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (8, 'Alternativa03', 0, 2);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (9, 'Alternativa04', 1, 2);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (10, 'Alternativa05', 0, 2);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (11, 'Alternativa01', 0, 3);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (12, 'Alternativa02', 0, 3);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (13, 'Alternativa03', 1, 3);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (14, 'Alternativa04', 0, 3);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (15, 'Alternativa05', 0, 3);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (16, 'Alternativa01', 1, 4);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (17, 'Alternativa02', 0, 4);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (18, 'Alternativa03', 0, 4);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (19, 'Alternativa04', 0, 4);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (20, 'Alternativa05', 0, 4);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (21, 'Alternativa01', 0, 5);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (22, 'Alternativa02', 1, 5);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (23, 'Alternativa03', 0, 5);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (24, 'Alternativa04', 0, 5);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (25, 'Alternativa05', 0, 5);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (26, 'Alternativa01', 0, 6);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (27, 'Alternativa02', 0, 6);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (28, 'Alternativa03', 0, 6);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (29, 'Alternativa04', 1, 6);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (30, 'Alternativa05', 0, 6);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (31, 'Alternativa01', 0, 7);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (32, 'Alternativa02', 0, 7);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (33, 'Alternativa03', 0, 7);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (34, 'Alternativa04', 0, 7);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (35, 'Alternativa05', 1, 7);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (36, 'Alternativa01', 1, 8);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (37, 'Alternativa02', 0, 8);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (38, 'Alternativa03', 0, 8);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (39, 'Alternativa04', 0, 8);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (40, 'Alternativa05', 0, 8);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (41, 'Alternativa01', 0, 9);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (42, 'Alternativa02', 0, 9);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (43, 'Alternativa03', 1, 9);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (44, 'Alternativa04', 0, 9);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (45, 'Alternativa05', 0, 9);

insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (46, 'Alternativa01', 0, 10);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (47, 'Alternativa02', 1, 10);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (48, 'Alternativa03', 0, 10);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (49, 'Alternativa04', 0, 10);
insert into tb_resposta (id_resposta, resposta, resposta_correta, id_questao) values (50, 'Alternativa05', 0, 10);