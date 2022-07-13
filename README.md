# aula-conexao-oracle
Aula em que demonstro as formas de se conectar com o banco de dados Oracle 21c


# Tabela


--------------------------------------------------------
--  DDL for Table PESSOA
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."PESSOA" 
   (	"ID" NUMBER(19,0), 
	"NOME" VARCHAR2(255 BYTE), 
	"SOBRENOME" VARCHAR2(255 BYTE)
   ) ;
