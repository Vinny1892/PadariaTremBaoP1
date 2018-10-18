-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 19/10/2018 às 00:31
-- Versão do servidor: 10.1.36-MariaDB
-- Versão do PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `padariatrembao2`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cartao_fidelidade`
--

CREATE TABLE `cartao_fidelidade` (
  `idcartao_fidelidade` int(10) UNSIGNED NOT NULL,
  `cliente_idcliente` int(10) UNSIGNED NOT NULL,
  `gold` tinyint(1) DEFAULT NULL,
  `platinum` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `idcartao_fidelidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nome`, `endereco`, `cpf`, `telefone`, `idcartao_fidelidade`) VALUES
(1, 'Roberto riba', 'Rua Pitanga', '56666666666', '88998899', 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

CREATE TABLE `estoque` (
  `idestoque` int(10) UNSIGNED NOT NULL,
  `produto_idproduto` int(10) UNSIGNED NOT NULL,
  `data_validade` int(10) UNSIGNED DEFAULT NULL,
  `quantidade` int(8) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `idfornecedor` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `taxa_desconto` int(8) NOT NULL DEFAULT '0',
  `recorrente` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `gerente`
--

CREATE TABLE `gerente` (
  `idgerente` int(10) UNSIGNED NOT NULL,
  `nome` varchar(12) NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `salario_base_mensal` float NOT NULL,
  `porcentagem_gratificacao` int(3) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `gerente`
--

INSERT INTO `gerente` (`idgerente`, `nome`, `cpf`, `endereco`, `telefone`, `salario_base_mensal`, `porcentagem_gratificacao`) VALUES
(3, 'eduardogomes', '22222233333', 'rua gerente1', '556700323232', 3000, 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `padeiro`
--

CREATE TABLE `padeiro` (
  `idpadeiro` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `horario_alternativo` float DEFAULT '0',
  `salario_base_mensal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `padeiro`
--

INSERT INTO `padeiro` (`idpadeiro`, `nome`, `endereco`, `cpf`, `telefone`, `horario_alternativo`, `salario_base_mensal`) VALUES
(1, 'luiz', 'rua do luiz', '22222255555', '675555555555', 2, 4000),
(6, 'luiz', 'Rua luizinho', '12345678912', '345678', 0, 4000);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `idproduto` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(50) NOT NULL,
  `preco_custo` float NOT NULL,
  `id_fornecedor` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `id_venda` int(11) NOT NULL,
  `data_venda` datetime NOT NULL,
  `forma_pagamento` int(2) NOT NULL,
  `montante_venda` float NOT NULL,
  `id_produto` int(12) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `id_cliente` binary(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendedor`
--

CREATE TABLE `vendedor` (
  `idvendedor` int(10) UNSIGNED NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `cpf` int(11) UNSIGNED DEFAULT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `salario_base` float DEFAULT NULL,
  `montante_venda` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `cartao_fidelidade`
--
ALTER TABLE `cartao_fidelidade`
  ADD PRIMARY KEY (`idcartao_fidelidade`),
  ADD KEY `cartao_fidelidade_FKIndex1` (`cliente_idcliente`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD UNIQUE KEY `cpf` (`cpf`),
  ADD KEY `idcartao_fidelidade` (`idcartao_fidelidade`);

--
-- Índices de tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`idestoque`),
  ADD KEY `estoque_FKIndex1` (`produto_idproduto`);

--
-- Índices de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`idfornecedor`),
  ADD UNIQUE KEY `cnpj` (`cnpj`);

--
-- Índices de tabela `gerente`
--
ALTER TABLE `gerente`
  ADD PRIMARY KEY (`idgerente`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices de tabela `padeiro`
--
ALTER TABLE `padeiro`
  ADD PRIMARY KEY (`idpadeiro`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idproduto`),
  ADD KEY `idfornecedor` (`id_fornecedor`) USING BTREE;

--
-- Índices de tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`id_venda`),
  ADD KEY `idproduto` (`id_produto`) USING BTREE,
  ADD KEY `idcliente` (`id_cliente`) USING BTREE,
  ADD KEY `idvendedor` (`id_vendedor`) USING BTREE;

--
-- Índices de tabela `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`idvendedor`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `cartao_fidelidade`
--
ALTER TABLE `cartao_fidelidade`
  MODIFY `idcartao_fidelidade` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `idestoque` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `idfornecedor` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `gerente`
--
ALTER TABLE `gerente`
  MODIFY `idgerente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `padeiro`
--
ALTER TABLE `padeiro`
  MODIFY `idpadeiro` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idproduto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `id_venda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `idvendedor` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `cartao_fidelidade`
--
ALTER TABLE `cartao_fidelidade`
  ADD CONSTRAINT `cartao_fidelidade_ibfk_1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`produto_idproduto`) REFERENCES `produto` (`idproduto`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
