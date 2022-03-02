drop database gerador_prova; 
create database gerador_prova;

create type tipo_questao as enum ('ABERTA', 'ESCOLHA_UNICA', 'ESCOLHA_MULTIPLA');
create type dificuldade as enum ('FACIL', 'MEDIO', 'DIFICIL');

create table tb_prova(
	id_prova serial not null primary key,
	titulo varchar(100) not null,
	finalizada boolean default false,
	corrigida boolean default false,
	nota decimal(5,2)
);

create table tb_tag(
	id_tag serial not null primary key,
	tag varchar(30) not null
);

create table tb_questao(
	id_questao serial not null primary key,
	enunciado varchar(100) not null,
	tipo_questao tipo_questao not null,
	dificuldade dificuldade not null,
	id_tag int not null,
	constraint fk_questao_tag foreign key(id_tag) references tb_tag(id_tag)
);


create table tb_resposta(
	id_resposta serial not null primary key,
	resposta varchar(150),
	resposta_correta boolean default false,
	id_questao int not null,
	constraint fk_resposta_questao foreign key(id_questao) references tb_questao(id_questao) 
);


create table tb_questao_historico(
	id_questao_historico serial not null primary key,
	enunciado varchar(100) not null,
	tipo_questao tipo_questao not null,
	tag varchar(30) not null,
	id_prova int not null,
	id_questao int not null,
	constraint fk_questao_historico_prova foreign key(id_prova) references tb_prova(id_prova),
	constraint fk_questao_historico_questao foreign key(id_questao) references tb_questao(id_questao)
);

create table tb_resposta_historico(
	id_resposta_historico serial not null primary key,
	resposta varchar(150),
	resposta_correta boolean default false,
	selecionado boolean default false,
	id_questao_historico int not null,
	constraint fk_resposta_historico_questao foreign key(id_questao_historico) references tb_questao_historico(id_questao_historico) 
);