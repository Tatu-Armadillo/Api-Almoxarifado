create database almoxarifado;

use almoxarifado;

-- create table tb_usuarios (
--     id_usuario bigint auto_increment primary key,
--     login varchar(20),
--     senha varchar(200),
--     unique (id_usuario, login)
-- );

-- create table tb_usuarios_perfis (
-- 	id_usuarios_perfis bigint auto_increment primary key,
--     nome varchar(50)
-- );

create table tb_itens (
    id_item bigint auto_increment primary key,
    nome_item varchar(20),
    codigo varchar(10),
    unique (id_item, codigo)
);

create table tb_responsaveis (
    id_responsavel bigint auto_increment primary key unique,
    nome varchar(50),
    numero_contato varchar(10)
);

create table tb_movimentos (
    id_movimentos bigint auto_increment primary key,
    data datetime,
    entrada_saida bit,
    fk_itens_id_item bigint,
    fk_responsaveis_id_responsavel bigint
    -- fk_usuarios_id_usuario bigint,
);

-- create table tb_perfil (
-- 	id_perfil bigint auto_increment primary key,
--     nome varchar(50)
-- );
 
alter table tb_movimentos add constraint fk_movimentos_2
    foreign key (fk_itens_id_item)
    references tb_itens (id_item)
    on delete restrict;
    
alter table tb_movimentos add constraint fk_movimentos_4
    foreign key (fk_responsaveis_id_responsavel)
    references tb_responsaveis (id_responsavel)
    on delete restrict;
 
-- alter table tb_movimentos add constraint fk_movimentos_3
--     foreign key (fk_usuarios_id_usuario)
--     references tb_usuarios (id_usuario)
--     on delete restrict;
 
    