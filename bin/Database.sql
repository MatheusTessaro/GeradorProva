create database gerador_prova;

create type tipo_questao as enum ('ABERTA', 'ESCOLHA_UNICA', 'ESCOLHA_MULTIPLA');
create type dificuldade as enum ('FACIL', 'MEDIO', 'DIFICIL');
create type prova_state as enum ('ABERTA', 'FINALIZADA', 'CORRIGIDA');
create type tipo_usuario as enum ('ALUNO', 'PROFESSOR', 'ADMIN');

create table tb_prova(
	id_prova serial not null primary key,
	titulo varchar(100) not null,
	tag varchar(50),
	state prova_state default 'ABERTA',
	nota decimal(5,2)
);

create table tb_tag(
	id_tag serial not null primary key,
	nome varchar(50) not null unique
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
	id_questao int4,
	constraint fk_resposta_questao foreign key(id_questao) references tb_questao(id_questao) 
);


create table tb_questao_historico(
	id_questao_historico serial not null primary key,
	enunciado varchar(100) not null,
	tipo_questao tipo_questao not null,
	dificuldade dificuldade not null,
	valor decimal(5,2),
	nota decimal(5,2),
	id_prova int4,
	constraint fk_questao_historico_prova foreign key(id_prova) references tb_prova(id_prova)
);

create table tb_resposta_historico(
	id_resposta_historico serial not null primary key,
	resposta varchar(150),
	resposta_correta int default 0,
	selecionado int default 0,
	id_questao_historico int4,
	constraint fk_resposta_historico_questao foreign key(id_questao_historico) references tb_questao_historico(id_questao_historico) 
);


create table tb_usuario(
	id_usuario serial not null primary key,
	nome varchar(50) not null,
	login varchar(50) not null,
	senha varchar(50) not null,
	tipo tipo_usuario not null 
);

insert into tb_usuario (nome, login, senha, tipo) values ('admin', 'admin', 'admin', 'ADMIN');
insert into tb_usuario (nome, login, senha, tipo) values ('aluno', 'aluno', 'aluno', 'ALUNO');
insert into tb_usuario (nome, login, senha, tipo) values ('professor', 'professor', 'professor', 'PROFESSOR');