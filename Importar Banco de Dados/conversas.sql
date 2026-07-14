-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13/07/2026 às 20:56
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `conversas`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `contato`
--

CREATE TABLE `contato` (
  `id_contato` int(11) NOT NULL,
  `id_pessoa` int(11) NOT NULL,
  `id_telefone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `contato`
--

INSERT INTO `contato` (`id_contato`, `id_pessoa`, `id_telefone`) VALUES
(4, 1, 2),
(5, 2, 4),
(6, 2, 1),
(7, 3, 1),
(8, 1, 4),
(11, 1, 6),
(12, 5, 1),
(13, 6, 1),
(14, 1, 7);

-- --------------------------------------------------------

--
-- Estrutura para tabela `mensagens`
--

CREATE TABLE `mensagens` (
  `ID_mensagem` int(11) NOT NULL,
  `Mensagem` varchar(200) NOT NULL,
  `ID_destinatario` int(11) NOT NULL,
  `ID_remetente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `mensagens`
--

INSERT INTO `mensagens` (`ID_mensagem`, `Mensagem`, `ID_destinatario`, `ID_remetente`) VALUES
(1, 'Oi', 2, 1),
(2, 'oi como você está?', 1, 2),
(3, 'Oi como você está', 4, 2),
(4, 'oi', 4, 1),
(5, 'eai', 1, 4),
(6, 'eai quer jogar?', 1, 2),
(8, 'oi', 6, 1),
(9, 'Bom dia Lucas está tudo bem?', 1, 7),
(10, 'oi tudo', 7, 1),
(11, 'você é um totoso', 7, 1),
(12, 'teste', 4, 1),
(13, 'batata', 2, 1),
(14, 'Quem ta lendo é gay', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `ID_pessoa` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `sexo` char(1) NOT NULL,
  `dataNasc` date NOT NULL,
  `Nacionalidade` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `pessoa`
--

INSERT INTO `pessoa` (`ID_pessoa`, `nome`, `sexo`, `dataNasc`, `Nacionalidade`) VALUES
(1, 'Lucas', 'M', '2009-09-07', 'BR'),
(2, 'Matheus', 'M', '2000-01-01', 'BR'),
(3, 'Felipe', 'M', '2009-06-18', 'BR'),
(5, 'Maria', 'F', '2008-07-29', 'Argentina'),
(6, 'Manuel', 'M', '2002-02-20', 'Angolano');

-- --------------------------------------------------------

--
-- Estrutura para tabela `telefone`
--

CREATE TABLE `telefone` (
  `ID_fone` int(11) NOT NULL,
  `fone` varchar(20) NOT NULL,
  `Nacionalidade_fone` int(2) NOT NULL,
  `ID_pessoa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `telefone`
--

INSERT INTO `telefone` (`ID_fone`, `fone`, `Nacionalidade_fone`, `ID_pessoa`) VALUES
(1, '12345678', 55, 1),
(2, '123', 55, 2),
(4, '999666', 55, 3),
(6, '999000', 54, 5),
(7, '5199759953', 55, 6);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `contato`
--
ALTER TABLE `contato`
  ADD PRIMARY KEY (`id_contato`),
  ADD KEY `id_pessoa` (`id_pessoa`),
  ADD KEY `id_telefone` (`id_telefone`);

--
-- Índices de tabela `mensagens`
--
ALTER TABLE `mensagens`
  ADD PRIMARY KEY (`ID_mensagem`),
  ADD KEY `ID_remetente` (`ID_remetente`),
  ADD KEY `ID_destinatário` (`ID_destinatario`);

--
-- Índices de tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`ID_pessoa`);

--
-- Índices de tabela `telefone`
--
ALTER TABLE `telefone`
  ADD PRIMARY KEY (`ID_fone`),
  ADD KEY `ID_pessoa` (`ID_pessoa`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `contato`
--
ALTER TABLE `contato`
  MODIFY `id_contato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `mensagens`
--
ALTER TABLE `mensagens`
  MODIFY `ID_mensagem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `ID_pessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `telefone`
--
ALTER TABLE `telefone`
  MODIFY `ID_fone` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `contato`
--
ALTER TABLE `contato`
  ADD CONSTRAINT `contato_ibfk_3` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`ID_pessoa`) ON DELETE CASCADE,
  ADD CONSTRAINT `contato_ibfk_4` FOREIGN KEY (`id_telefone`) REFERENCES `telefone` (`ID_fone`) ON DELETE CASCADE;

--
-- Restrições para tabelas `mensagens`
--
ALTER TABLE `mensagens`
  ADD CONSTRAINT `mensagens_ibfk_3` FOREIGN KEY (`ID_destinatario`) REFERENCES `telefone` (`ID_fone`) ON DELETE CASCADE,
  ADD CONSTRAINT `mensagens_ibfk_4` FOREIGN KEY (`ID_remetente`) REFERENCES `telefone` (`ID_fone`) ON DELETE CASCADE;

--
-- Restrições para tabelas `telefone`
--
ALTER TABLE `telefone`
  ADD CONSTRAINT `telefone_ibfk_1` FOREIGN KEY (`ID_pessoa`) REFERENCES `pessoa` (`ID_pessoa`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
