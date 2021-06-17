create DATABASE Almoxarifado;

use Almoxarifado;

-- CREATE TABLE tb_usuarios (
--     id_usuario long auto_increment PRIMARY KEY,
--     Login Varchar(20),
--     Senha Varchar(200),
--     UNIQUE (id_usuario, Login)
-- );

-- create table tb_usuarios_perfis (
-- 	id_usuarios_perfis long auto_increment PRIMARY KEY,
--     nome varchar(50)
-- );

CREATE TABLE tb_itens (
    id_item long auto_increment PRIMARY KEY,
    Nome_Item Varchar(20),
    Codigo Varchar(10),
    UNIQUE (id_item, Codigo)
);

CREATE TABLE tb_responsaveis (
    id_responsavel long auto_increment PRIMARY KEY UNIQUE,
    Nome Varchar(50),
    Numero_Contato Varchar(10)
);

CREATE TABLE tb_movimentos (
    id_movimentos long auto_increment PRIMARY KEY,
    Data DateTime,
    Entrada_Saida BIT,
    fk_Itens_id_item long,
    fk_Responsaveis_id_responsavel long
    -- fk_Usuarios_id_usuario long,
);

-- create table tb_perfil (
-- 	id_perfil long auto_increment PRIMARY KEY,
--     nome varchar(50)
-- );
 
ALTER TABLE tb_movimentos ADD CONSTRAlong FK_Movimentos_2
    FOREIGN KEY (fk_Itens_id_item)
    REFERENCES tb_itens (id_item)
    ON DELETE RESTRICT;
    
ALTER TABLE tb_movimentos ADD CONSTRAlong FK_Movimentos_4
    FOREIGN KEY (fk_Responsaveis_id_responsavel)
    REFERENCES tb_responsaveis (id_responsavel)
    ON DELETE RESTRICT;
 
-- ALTER TABLE tb_movimentos ADD CONSTRAlong FK_Movimentos_3
--     FOREIGN KEY (fk_Usuarios_id_usuario)
--     REFERENCES tb_usuarios (id_usuario)
--     ON DELETE RESTRICT;
 
    