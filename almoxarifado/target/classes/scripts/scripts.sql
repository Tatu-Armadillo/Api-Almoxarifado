create DATABASE Almoxarifado;

use Almoxarifado;

CREATE TABLE tb_usuarios (
    id_adm Int auto_increment PRIMARY KEY,
    Login Varchar(20),
    Senha Varchar(200),
    UNIQUE (id_adm, Login)
);

CREATE TABLE tb_itens (
    id_item Int auto_increment PRIMARY KEY,
    Nome_Item Varchar(20),
    Codigo Varchar(10),
    UNIQUE (id_item, Codigo)
);

CREATE TABLE tb_responsaveis (
    id_responsavel Int auto_increment PRIMARY KEY UNIQUE,
    Nome Varchar(50),
    Numero_Contato Varchar(10)
);

CREATE TABLE tb_movimentos (
    id_movimentos Int auto_increment PRIMARY KEY,
    Data DateTime,
    Entrada_Saida BIT,
    fk_Itens_id_item Int,
    fk_Usuarios_id_adm Int,
    fk_Responsaveis_id_responsavel Int
);

create table tb_usuarios_perfis (
	id_usuarios_perfis Int auto_increment PRIMARY KEY,
    nome varchar(50)
);

create table tb_perfil (
	id_perfil Int auto_increment PRIMARY KEY,
    nome varchar(50)
);
 
ALTER TABLE tb_movimentos ADD CONSTRAINT FK_Movimentos_2
    FOREIGN KEY (fk_Itens_id_item)
    REFERENCES tb_itens (id_item)
    ON DELETE RESTRICT;
 
ALTER TABLE tb_movimentos ADD CONSTRAINT FK_Movimentos_3
    FOREIGN KEY (fk_Usuarios_id_adm)
    REFERENCES tb_usuarios (id_adm)
    ON DELETE RESTRICT;
 
ALTER TABLE tb_movimentos ADD CONSTRAINT FK_Movimentos_4
    FOREIGN KEY (fk_Responsaveis_id_responsavel)
    REFERENCES tb_responsaveis (id_responsavel)
    ON DELETE RESTRICT;
    