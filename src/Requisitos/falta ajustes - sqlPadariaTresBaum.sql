CREATE TABLE padeiro (
  idpadeiro INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  endereco VARCHAR(50) NULL,
  cpf VARCHAR(11) NULL,
  telefone VARCHAR(12) NULL,
  salaio_base_mensal FLOAT(8) NULL,
  horarioalternativo FLOAT(3) NULL DEFAULT '0',
  PRIMARY KEY(idpadeiro)
);

CREATE TABLE gerente (
  idgerente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(12) NOT NULL,
  cpf VARCHAR(11) NULL,
  endereco VARCHAR(50) NULL,
  telefone VARCHAR(12) NULL,
  salario_base_mensal FLOAT(8) NOT NULL,
  porcentagem_gratificacao INTEGER(3) NULL DEFAULT '0',
  PRIMARY KEY(idgerente)
);

CREATE TABLE vendedor (
  idvendedor INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  endereco VARCHAR(50) NULL,
  cpf INTEGER(11) UNSIGNED NULL,
  telefone VARCHAR(12) NULL,
  salario_base FLOAT(8) NULL,
  montante_venda FLOAT(8) NOT NULL DEFAULT '0',
  PRIMARY KEY(idvendedor)
);

CREATE TABLE produto (
  idproduto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  codigo INTEGER(6) UNSIGNED NOT NULL,
  nome VARCHAR(50) NOT NULL,
  apelido VARCHAR(50) NOT NULL,
  preco_custo FLOAT(6) NOT NULL,
  preco_final FLOAT(6) NOT NULL,
  perecivel BOOL NOT NULL,
  id_fornecedor INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idproduto, codigo)
);

CREATE TABLE cliente (
  idcliente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NULL,
  endereco VARCHAR(50) NULL,
  cpf VARCHAR(11) NOT NULL,
  telefone VARCHAR(12) NULL,
  PRIMARY KEY(idcliente)
);

CREATE TABLE fornecedor (
  idfornecedor INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(50) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  endereco VARCHAR(50) NOT NULL,
  taxa_desconto INTEGER(8) NOT NULL DEFAULT '0',
  recorrente BOOL NOT NULL,
  PRIMARY KEY(idfornecedor)
);

CREATE TABLE cartao_fidelidade (
  idcartao_fidelidade INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  cliente_idcliente INTEGER UNSIGNED NOT NULL,
  gold BOOL NULL,
  platinum BOOL NULL,
  PRIMARY KEY(idcartao_fidelidade),
  INDEX cartao_fidelidade_FKIndex1(cliente_idcliente),
  FOREIGN KEY(cliente_idcliente)
    REFERENCES cliente(idcliente)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

CREATE TABLE estoque (
  idestoque INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  produto_codigo INTEGER(6) UNSIGNED NOT NULL,
  produto_idproduto INTEGER UNSIGNED NOT NULL,
  data_validade INTEGER UNSIGNED NULL,
  quantidade INTEGER(8) UNSIGNED NULL,
  PRIMARY KEY(idestoque),
  INDEX estoque_FKIndex1(produto_idproduto, produto_codigo),
  FOREIGN KEY(produto_idproduto, produto_codigo)
    REFERENCES produto(idproduto, codigo)
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

CREATE TABLE venda (
  idvenda INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  estoque_idestoque INTEGER UNSIGNED NOT NULL,
  data_venda DATE NOT NULL,
  forma_pagamento INTEGER UNSIGNED NOT NULL,
  montante_venda FLOAT NOT NULL,
  id_produto INTEGER UNSIGNED NOT NULL,
  id_vendedor INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(idvenda),
  INDEX venda_FKIndex1(estoque_idestoque),
  FOREIGN KEY(estoque_idestoque)
    REFERENCES estoque(idestoque)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


