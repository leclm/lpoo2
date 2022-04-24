CREATE DATABASE tpoo2;
USE tpoo2;

CREATE TABLE cliente(
    id INT UNIQUE NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    nome VARCHAR(20) NOT NULL,
    sobrenome VARCHAR(20) NOT NULL,
    rg VARCHAR(11) NOT NULL UNIQUE,
    salario DOUBLE NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);  

CREATE TABLE conta(
    numeroConta INT NOT NULL UNIQUE AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    saldoConta DOUBLE NOT NULL,
    limiteConta DOUBLE,
    saqueMinimo DOUBLE,
    depositoMinimo DOUBLE,
    tipoConta INT NOT NULL,
    montanteMinimo DOUBLE,
    PRIMARY KEY (numeroConta),
    FOREIGN KEY (cpf) REFERENCES cliente (cpf)
);