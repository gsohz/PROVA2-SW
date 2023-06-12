-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12-Jun-2023 às 13:59
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `prova2`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(5) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `grade` int(3) DEFAULT NULL,
  `id_salesman` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `customer`
--

INSERT INTO `customer` (`id_customer`, `name`, `city`, `grade`, `id_salesman`) VALUES
(12235, 'Luan', 'São Vicente', 8, NULL),
(12236, 'Fabio', 'Cubatão', 9, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `orders`
--

CREATE TABLE `orders` (
  `id_orders` int(5) NOT NULL,
  `purch_amt` decimal(8,2) DEFAULT NULL,
  `ord_date` date DEFAULT NULL,
  `id_customer` int(5) NOT NULL,
  `id_salesman` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `orders`
--

INSERT INTO `orders` (`id_orders`, `purch_amt`, `ord_date`, `id_customer`, `id_salesman`) VALUES
(1, '12356.60', '2023-06-12', 12236, 12443),
(2, '23451.25', '2023-06-11', 12235, 12443),
(3, '5985.40', '2023-06-08', 12235, 10829);

-- --------------------------------------------------------

--
-- Estrutura da tabela `salesman`
--

CREATE TABLE `salesman` (
  `id_salesman` int(5) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `comission` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `salesman`
--

INSERT INTO `salesman` (`id_salesman`, `name`, `city`, `comission`) VALUES
(10829, 'Paulo', 'São Paulo', '100.50'),
(12443, 'João', 'Praia Grande', '42.43');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Índices para tabela `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id_orders`),
  ADD KEY `fk_orders_customer_idx` (`id_customer`),
  ADD KEY `fk_orders_salesman1_idx` (`id_salesman`);

--
-- Índices para tabela `salesman`
--
ALTER TABLE `salesman`
  ADD PRIMARY KEY (`id_salesman`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12237;

--
-- AUTO_INCREMENT de tabela `orders`
--
ALTER TABLE `orders`
  MODIFY `id_orders` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_orders_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orders_salesman1` FOREIGN KEY (`id_salesman`) REFERENCES `salesman` (`id_salesman`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
