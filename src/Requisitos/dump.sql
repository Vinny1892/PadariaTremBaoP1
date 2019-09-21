-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Tempo de geração: 21-Set-2019 às 20:57
-- Versão do servidor: 8.0.17
-- versão do PHP: 7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `padaria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cartao_fidelidade`
--

CREATE TABLE `cartao_fidelidade` (
  `id_cartao` int(11) NOT NULL,
  `gold` tinyint(1) NOT NULL,
  `platinum` tinyint(1) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(10) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `id_cartao_fidelidade` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `id_estoque` int(10) NOT NULL,
  `data_validade` varchar(20) NOT NULL,
  `id_produto` int(10) NOT NULL,
  `quantidade` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id_fornecedor` int(10) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `cnpj` varchar(15) NOT NULL,
  `recorrente` tinyint(1) NOT NULL,
  `taxa_desconto` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gerente`
--

CREATE TABLE `gerente` (
  `id_gerente` int(10) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `porcetagem_gratificacao` float NOT NULL,
  `salario_base` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `padeiro`
--

CREATE TABLE `padeiro` (
  `id_padeiro` int(10) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `horario_alternativo` float NOT NULL,
  `salario_base` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(50) NOT NULL,
  `preco_custo` float NOT NULL,
  `id_fornecedor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE `vendas` (
  `id_venda` int(10) NOT NULL,
  `data_venda` varchar(20) NOT NULL,
  `forma_pagamento` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `id_estoque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedor`
--

CREATE TABLE `vendedor` (
  `id_vendedor` int(10) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `salario_base` float NOT NULL,
  `montante_vendas` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cartao_fidelidade`
--
ALTER TABLE `cartao_fidelidade`
  ADD PRIMARY KEY (`id_cartao`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices para tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id_estoque`);

--
-- Índices para tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id_fornecedor`);

--
-- Índices para tabela `gerente`
--
ALTER TABLE `gerente`
  ADD PRIMARY KEY (`id_gerente`);

--
-- Índices para tabela `padeiro`
--
ALTER TABLE `padeiro`
  ADD PRIMARY KEY (`id_padeiro`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- Índices para tabela `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`id_vendedor`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cartao_fidelidade`
--
ALTER TABLE `cartao_fidelidade`
  MODIFY `id_cartao` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id_estoque` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id_fornecedor` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `gerente`
--
ALTER TABLE `gerente`
  MODIFY `id_gerente` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `padeiro`
--
ALTER TABLE `padeiro`
  MODIFY `id_padeiro` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `id_vendedor` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
