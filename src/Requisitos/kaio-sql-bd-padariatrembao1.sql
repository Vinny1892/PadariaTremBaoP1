-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 16/10/2018 às 18:57
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
-- Banco de dados: `padariatrembao1`
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
  `telefone` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

CREATE TABLE `estoque` (
  `idestoque` int(10) UNSIGNED NOT NULL,
  `produto_codigo` int(6) UNSIGNED NOT NULL,
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
  `recorrente` tinyint(1) NOT NULL,
  `taxa_desconto` int(3) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `fornecedor`
--

INSERT INTO `fornecedor` (`idfornecedor`, `nome`, `cnpj`, `endereco`, `recorrente`, `taxa_desconto`) VALUES
(1, 'nome11', '21111111111111', 'end11', 10, 1),
(2, 'nome1', '11111111111111', 'endereco1', 1, 10);

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
  `salario_base_mensal` float DEFAULT NULL,
  `horarioalternativo` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `idproduto` int(10) UNSIGNED NOT NULL,
  `codigo` int(6) UNSIGNED NOT NULL,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(50) NOT NULL,
  `preco_custo` float NOT NULL,
  `preco_final` float NOT NULL,
  `perecivel` tinyint(1) NOT NULL,
  `id_fornecedor` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto_has_fornecedor`
--

CREATE TABLE `produto_has_fornecedor` (
  `produto_idproduto` int(10) UNSIGNED NOT NULL,
  `fornecedor_idfornecedor` int(10) UNSIGNED NOT NULL,
  `produto_codigo` int(6) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `venda`
--

CREATE TABLE `venda` (
  `idvenda` int(10) UNSIGNED NOT NULL,
  `estoque_idestoque` int(10) UNSIGNED NOT NULL,
  `data_venda` date NOT NULL,
  `forma_pagamento` int(10) UNSIGNED NOT NULL,
  `montante_venda` float NOT NULL,
  `id_produto` int(10) UNSIGNED NOT NULL,
  `id_vendedor` int(10) UNSIGNED NOT NULL
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
  ADD PRIMARY KEY (`idcliente`);

--
-- Índices de tabela `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`idestoque`),
  ADD KEY `estoque_FKIndex1` (`produto_idproduto`,`produto_codigo`);

--
-- Índices de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`idfornecedor`);

--
-- Índices de tabela `gerente`
--
ALTER TABLE `gerente`
  ADD PRIMARY KEY (`idgerente`);

--
-- Índices de tabela `padeiro`
--
ALTER TABLE `padeiro`
  ADD PRIMARY KEY (`idpadeiro`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`idproduto`,`codigo`);

--
-- Índices de tabela `produto_has_fornecedor`
--
ALTER TABLE `produto_has_fornecedor`
  ADD PRIMARY KEY (`produto_idproduto`,`fornecedor_idfornecedor`,`produto_codigo`),
  ADD KEY `produto_has_fornecedor_FKIndex1` (`produto_idproduto`,`produto_codigo`),
  ADD KEY `produto_has_fornecedor_FKIndex2` (`fornecedor_idfornecedor`);

--
-- Índices de tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idvenda`),
  ADD KEY `venda_FKIndex1` (`estoque_idestoque`);

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
  MODIFY `idcliente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `estoque`
--
ALTER TABLE `estoque`
  MODIFY `idestoque` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `idfornecedor` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `gerente`
--
ALTER TABLE `gerente`
  MODIFY `idgerente` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `padeiro`
--
ALTER TABLE `padeiro`
  MODIFY `idpadeiro` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `idproduto` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `idvenda` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`produto_idproduto`,`produto_codigo`) REFERENCES `produto` (`idproduto`, `codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `produto_has_fornecedor`
--
ALTER TABLE `produto_has_fornecedor`
  ADD CONSTRAINT `produto_has_fornecedor_ibfk_1` FOREIGN KEY (`produto_idproduto`,`produto_codigo`) REFERENCES `produto` (`idproduto`, `codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `produto_has_fornecedor_ibfk_2` FOREIGN KEY (`fornecedor_idfornecedor`) REFERENCES `fornecedor` (`idfornecedor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`estoque_idestoque`) REFERENCES `estoque` (`idestoque`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
