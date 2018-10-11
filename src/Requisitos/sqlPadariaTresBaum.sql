CREATE TABLE produto (
  idproduto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  codigo INTEGER(6) UNSIGNED NOT NULL,
  preco_custo FLOAT(6) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  preco_final FLOAT(6) NOT NULL,
  perecivel BOOL NOT NULL,
  data_validade DATE NOT NULL,
  apelido VARCHAR(50) NOT NULL,
  id_fornecedor INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idproduto, codigo)
);

CREATE TABLE venda (
  idvenda INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  data_venda DATE NOT NULL,
  forma_pagamento INTEGER UNSIGNED NOT NULL,
  montante_venda FLOAT NOT NULL,
  id_produto INTEGER UNSIGNED NOT NULL,
  id_vendedor INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idvenda)
);

CREATE TABLE padeiro (
  idpadeiro INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  endereco VARCHAR(50) NULL,
  cpf VARCHAR(11) NULL,
  telefone VARCHAR(12) NULL,
  salaio_base_mensal FLOAT(8) NULL,
  valorgratificacao FLOAT(8) NULL,
  horarioalternativo FLOAT(3) NULL,
  PRIMARY KEY(idpadeiro)
);

CREATE TABLE fornecedor (
  idfornecedor INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  endereco VARCHAR(50) NOT NULL,
  recorrente BOOL NOT NULL,
  PRIMARY KEY(idfornecedor)
);

CREATE TABLE gerente (
  idgerente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR NOT NULL,
  endereco VARCHAR NOT NULL,
  telefone_2 VARCHAR(11) NOT NULL,
  telefone VARCHAR(12) NOT NULL,
  salario_base_mensal FLOAT(8) NOT NULL,
  gratificacao FLOAT(8) NOT NULL,
  PRIMARY KEY(idgerente)
);

CREATE TABLE produto_has_venda (
  venda_idvenda INTEGER UNSIGNED NOT NULL,
  produto_codigo INTEGER(6) UNSIGNED NOT NULL,
  produto_idproduto INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(venda_idvenda, produto_codigo, produto_idproduto),
  INDEX produto_has_venda_FKIndex1(produto_idproduto, produto_codigo),
  INDEX produto_has_venda_FKIndex2(venda_idvenda),
  FOREIGN KEY(produto_idproduto, produto_codigo)
    REFERENCES produto(idproduto, codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(venda_idvenda)
    REFERENCES venda(idvenda)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE produto_has_fornecedor (
  produto_idproduto INTEGER UNSIGNED NOT NULL,
  fornecedor_idfornecedor INTEGER UNSIGNED NOT NULL,
  produto_codigo INTEGER(6) UNSIGNED NOT NULL,
  PRIMARY KEY(produto_idproduto, fornecedor_idfornecedor, produto_codigo),
  INDEX produto_has_fornecedor_FKIndex1(produto_idproduto, produto_codigo),
  INDEX produto_has_fornecedor_FKIndex2(fornecedor_idfornecedor),
  FOREIGN KEY(produto_idproduto, produto_codigo)
    REFERENCES produto(idproduto, codigo)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  FOREIGN KEY(fornecedor_idfornecedor)
    REFERENCES fornecedor(idfornecedor)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


