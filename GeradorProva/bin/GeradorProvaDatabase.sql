create database gerador_prova;

create table tb_prova(
	id_prova serial not null primary key,
	materia varchar(50) not null,
	titulo varchar(100) not null,
	is_finalizada int default 0,
	is_corrigida int default 0,
	nota double
);

create table tb_questao(
	id_questao serial not null primary key,
	enunciado varchar(100) not null,
	tipo_questao tipo_questao not null,
	id_prova int not null,
	foreign key(id_prova) references tb_prova(id_prova) 
);

create table tb_resposta(
	id_resposta not null primary key,
	resposta varchar(150),
	resposta_correta int default 0,
	selecionado int default 0,
	id_questao int not null,
	foreign key(id_questao) references tb_questao(id_questao) 
);