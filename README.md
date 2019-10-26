# passwordapp
Sistema para Controle de Senhas

Projeto voltado para Atendimento Bancário, que possibita somente 2 perfis de usuários: CLIENTE e GERENTE.

- Desenvolvido em Spring MVC com Hibernate e Maven.

- Tecnologias utilizadas:

Spring 4.1.5 RELEASE
Hibernate 4.3.8 Final
MySQL 5.1.10
PostgreSQL 9.4.24
Java 8
Eclipse
Tomcat 8
Maven

/*
## 1. CRIAÇÃO DE TABELAS - BANCO DE DADOS POSTGRESQL
*/

CREATE TABLE tipo_senha (
	sq_tipo_senha SERIAL PRIMARY KEY,
	descricao_tipo VARCHAR(30) UNIQUE NOT NULL,
	sigla_tipo VARCHAR(1) UNIQUE NOT NULL
);

CREATE TABLE senha (
	sq_senha SERIAL PRIMARY KEY,
	sq_tipo_senha INT NOT NULL,
	cd_senha VARCHAR(5) NOT NULL,
	dt_geracao DATE NOT NULL
);

ALTER TABLE senha ADD CONSTRAINT fk_tipo_senha FOREIGN KEY ( sq_tipo_senha) REFERENCES tipo_senha (sq_tipo_senha);

CREATE TABLE sequencial_senha (
	id INT NOT NULL PRIMARY KEY,
	nr_sequencial INT NOT NULL,
	dt_ultimo_sequencial DATE NOT NULL
);

/*
## 2. CRIAÇÃO DE TABELAS - BANCO DE DADOS MYSQL
*/

CREATE TABLE tipo_senha (
	sq_tipo_senha INT NOT NULL AUTO_INCREMENT,
	descricao_tipo VARCHAR(30) UNIQUE NOT NULL,
	sigla_tipo VARCHAR(1) UNIQUE NOT NULL,
	PRIMARY KEY (sq_tipo_senha)
);

CREATE TABLE senha (
	sq_senha INT NOT NULL AUTO_INCREMENT,
	sq_tipo_senha INT NOT NULL,
	cd_senha VARCHAR(5) NOT NULL,
	dt_geracao DATE NOT NULL,
	PRIMARY KEY (sq_senha)
);

ALTER TABLE senha ADD CONSTRAINT fk_tipo_senha FOREIGN KEY ( sq_tipo_senha) REFERENCES tipo_senha (sq_tipo_senha);

CREATE TABLE sequencial_senha (
	id INT NOT NULL,
	nr_sequencial INT(4) NOT NULL,
	dt_ultimo_sequencial DATE NOT NULL,
	PRIMARY KEY (id)
);

/*
## 3. Pós execução de um dos scripts acima, não esquecer de popular as TABELAS de apoio
*/

// populando tabela: tipo_senha
insert into tipo_senha(descricao_tipo, sigla_tipo) values ('NORMAL', 'N');
insert into tipo_senha(descricao_tipo, sigla_tipo) values ('PREFERENCIAL', 'P');

// populando tabela: sequencial_senha
INSERT INTO sequencial_senha values(1, 0, now());
INSERT INTO sequencial_senha values(2, 0, now());

/*
## 4. CONFIGURANDO APLICAÇÃO PARA O BANCO POSTGRES / MYSQL
*/

As configurações necessárias de acesso à banco são encontradas no arquivo denominado: "application.properties".

Nele será possível configurar a aplicação tanto para o banco de dados PostgreSQL ou para o banco MySQL, opcional.

Os drivers necessários para estes tipos de configuração, são encontrados no arquivo "pom.xml".

Pós subir o servidor Tomcat, acessar aplicação via url:
http://localhost:8080/password/
