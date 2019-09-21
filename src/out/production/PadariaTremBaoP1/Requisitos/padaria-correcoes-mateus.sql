-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 19-Out-2018 às 11:01
-- Versão do servidor: 5.7.23-0ubuntu0.16.04.1
-- PHP Version: 7.0.32-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `padaria`
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
-- Indexes for dumped tables
--

--
-- Indexes for table `cartao_fidelidade`
--
ALTER TABLE `cartao_fidelidade`
  ADD PRIMARY KEY (`id_cartao`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id_estoque`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id_fornecedor`);

--
-- Indexes for table `gerente`
--
ALTER TABLE `gerente`
  ADD PRIMARY KEY (`id_gerente`);

--
-- Indexes for table `padeiro`
--
ALTER TABLE `padeiro`
  ADD PRIMARY KEY (`id_padeiro`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- Indexes for table `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`id_vendedor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cartao_fidelidade`
--
ALTER TABLE `cartao_fidelidade`
  MODIFY `id_cartao` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id_estoque` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id_fornecedor` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `gerente`
--
ALTER TABLE `gerente`
  MODIFY `id_gerente` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `padeiro`
--
ALTER TABLE `padeiro`
  MODIFY `id_padeiro` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `id_vendedor` int(10) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
