-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 24/10/2018 às 16:36
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
-- Banco de dados: `padariatrembao3`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cartao_fidelidade`
--

CREATE TABLE `cartao_fidelidade` (
  `id_cartao` int(11) NOT NULL,
  `gold` tinyint(1) NOT NULL,
  `platinum` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
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
-- Estrutura para tabela `estoque`
--

CREATE TABLE `estoque` (
  `id_estoque` int(10) NOT NULL,
  `data_validade` varchar(20) NOT NULL,
  `id_produto` int(10) NOT NULL,
  `quantidade` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `estoque`
--

INSERT INTO `estoque` (`id_estoque`, `data_validade`, `id_produto`, `quantidade`) VALUES
(1, '', 1, 10),
(2, '20/10/2018', 19, 20),
(3, '20/10/2018', 1, 20),
(4, '20/10/2030', 11, 10),
(5, '20/08/2019', 15, 10),
(6, '0', 18, 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id_fornecedor` int(10) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `cnpj` varchar(15) NOT NULL,
  `recorrente` tinyint(1) NOT NULL,
  `taxa_desconto` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id_fornecedor`, `nome`, `endereco`, `cnpj`, `recorrente`, `taxa_desconto`) VALUES
(3, 'TrigoSol', 'FazendaTrigoSol', '22222222222222', 1, 10),
(5, 'Cristal', 'Fazenda Cana', '11111111111111', 1, 10),
(6, 'União', 'Fazendo Cana', '77788899977788', 1, 10),
(8, 'Pó Royal', 'Fazenda Royal', '77788833322211', 0, 0),
(9, 'Dr Oetker', 'Fazenda Oetker', '66554455664411', 1, 3),
(10, 'Granja Bom Ovo', 'Fazenda Bom Ovo', '55441122337788', 1, 11),
(11, 'Italac', 'Fazenda Italac', '11001100110011', 1, 6),
(13, 'Caipira ', 'Fazenda Caipira', '11000000000001', 1, 3),
(14, 'Coca Cola', 'Fabrica Coca', '45997418000153', 1, 10),
(15, 'Sadia', 'Fabrica Sadia', '99994444555522', 1, 9);

-- --------------------------------------------------------

--
-- Estrutura para tabela `gerente`
--

CREATE TABLE `gerente` (
  `id_gerente` int(10) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `salario_base` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `gerente`
--

INSERT INTO `gerente` (`id_gerente`, `nome`, `cpf`, `endereco`, `telefone`, `salario_base`) VALUES
(1, 'Guilherme', '33333222221', 'Ruagenti', '99009900', 2000);

-- --------------------------------------------------------

--
-- Estrutura para tabela `padeiro`
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

--
-- Fazendo dump de dados para tabela `padeiro`
--

INSERT INTO `padeiro` (`id_padeiro`, `nome`, `cpf`, `endereco`, `telefone`, `horario_alternativo`, `salario_base`) VALUES
(1, 'luiz', '12345678912', 'Rua luizinho', '345678', 0, 4000);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(50) NOT NULL,
  `preco_custo` float NOT NULL,
  `id_fornecedor` int(10) NOT NULL,
  `perecivel` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `nome`, `apelido`, `preco_custo`, `id_fornecedor`, `perecivel`) VALUES
(1, 'leite em saco', 'leite saquinho', 10, 2, 0),
(2, 'Açucar', 'Açucar Cristal', 6.5, 5, 0),
(5, 'Fermento', 'fermento em pó', 7.5, 9, 0),
(6, 'Ovo', 'Ovo de granja', 0.7, 10, 0),
(7, 'Leite Condensado', 'leite', 7.5, 11, 1),
(8, 'Queijo Branco', 'Queijo Brando caipira', 25, 13, 1),
(9, 'Manteiga', 'manteiga', 10.5, 13, 1),
(10, 'Doce de leite', 'doce de leite', 15.5, 13, 1),
(11, 'Queijo trufado', 'trufado requeijão', 35.5, 13, 1),
(12, 'Carolina', 'carol', 0.3, 3, 1),
(13, 'Coca Cola', 'kUeka Koliéca', 6.5, 14, 1),
(14, 'Fanta', 'fankita Peskita', 5.5, 14, 1),
(15, 'Iogurte', 'guteGute GuteGola', 6.5, 13, 1),
(16, 'mortadela', 'motudela delaMutu', 4.5, 15, 1),
(17, 'Presunto', 'porquinho pro pão', 4.5, 15, 1),
(18, 'Coróti', 'só pra bebum', 2.5, 3, 0),
(19, 'Chipa', 'Chip da tim só 10 reais', 3.5, 3, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `id_venda` int(10) NOT NULL,
  `data_venda` varchar(20) NOT NULL,
  `forma_pagamento` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `id_estoque` int(11) NOT NULL,
  `valor_total_venda` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendedor`
--

CREATE TABLE `vendedor` (
  `id_vendedor` int(10) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(20) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `salario_base` float NOT NULL,
  `montante_vendas` float NOT NULL,
  `meta_venda` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `vendedor`
--

INSERT INTO `vendedor` (`id_vendedor`, `nome`, `cpf`, `endereco`, `telefone`, `salario_base`, `montante_vendas`, `meta_venda`) VALUES
(1, 'Jose', '22223345678', 'Rua Martine', '34452345', 2000, 10000, 2000),
(2, 'Tihiago martins', '55533322222', 'Rua Branco do SOl', '66998877', 2000, 5000, 2000),
(3, 'du', '12345612345', 'ergv', '66', 1200, 0, 2000);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `cartao_fidelidade`
--
ALTER TABLE `cartao_fidelidade`
  ADD PRIMARY KEY (`id_cartao`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices de tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id_estoque`);

--
-- Índices de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id_fornecedor`),
  ADD UNIQUE KEY `cnpj` (`cnpj`);

--
-- Índices de tabela `gerente`
--
ALTER TABLE `gerente`
  ADD PRIMARY KEY (`id_gerente`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices de tabela `padeiro`
--
ALTER TABLE `padeiro`
  ADD PRIMARY KEY (`id_padeiro`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`);

--
-- Índices de tabela `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`id_vendedor`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- AUTO_INCREMENT de tabelas apagadas
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
  MODIFY `id_estoque` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id_fornecedor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `gerente`
--
ALTER TABLE `gerente`
  MODIFY `id_gerente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `padeiro`
--
ALTER TABLE `padeiro`
  MODIFY `id_padeiro` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `id_vendedor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
