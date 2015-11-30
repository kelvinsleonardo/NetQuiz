-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- MÃ¡quina: localhost
-- Data de CriaÃ§Ã£o: 10-Nov-2015 Ã s 17:52
-- VersÃ£o do servidor: 5.5.46-0ubuntu0.14.04.2-log
-- versÃ£o do PHP: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `netquiz`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_pergunta`
--

CREATE TABLE IF NOT EXISTS `tb_pergunta` (
  `id_pergunta` int(11) NOT NULL AUTO_INCREMENT,
  `titulo_pergunta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pergunta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `tb_pergunta`
--

INSERT INTO `tb_pergunta` (`id_pergunta`, `titulo_pergunta`) VALUES
(1, 'Quem e o autor do Manifesto Comunista?'),
(2, 'Como e chamada a doenca que clareou a pele de Michael Jackson?'),
(3, 'Quem e o parceiro de aventuras de Dom Quixote?'),
(4, 'Violoncelo e um instrumento de?'),
(5, 'Em que estado brasileiro nasceu a apresentadora Xuxa?'),
(6, 'Qual era o apelido da cantora Elis Regina?'),
(7, 'Que imperador colocou fogo em Roma?'),
(8, 'A cidade de Pompeia, que foi soterrada por um vulcao fica em qual desses paises?'),
(9, 'Em que estadio Pele marcou seu milesimo gol?'),
(10,'O que e um oboe?'),
(11,'Quem realizou a primeira cirurgia de ponte de safena no brasil?'),
(12,'Quem disse a frase: "Vim, vi e venci"?'),
(13,'Beirute e a capital de que pais?'),
(14,'Qual e a capital do Iraque?'),
(15,'Qual presidente dos EUA foi ator de cinema?'),
(16,'Em que cidade brasileira fica o ITA?'),
(17,'O nome America foi associoado a qual desses nomes?'),
(18,'Em que ano ocorreu o incendio do edificio Joelma, na cidade de Sao Paulo?'),
(19,'Onde nasceu Van Gogh?'),
(20,'Qual oceano tem o maior volume de agua?')
;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_resposta`
--

CREATE TABLE IF NOT EXISTS `tb_resposta` (
  `id_resposta` int(11) NOT NULL AUTO_INCREMENT,
  `titulo_resposta` varchar(255) DEFAULT NULL,
  `valido` bit(1) DEFAULT NULL,
  `id_pergunta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_resposta`),
  KEY `FKpfqt1ey6jjw24kvkh7twj9kgc` (`id_pergunta`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `tb_resposta`
--

INSERT INTO `tb_resposta` (`id_resposta`, `titulo_resposta`, `valido`, `id_pergunta`) VALUES
(1, 'Lenin', b'0', 1),
(2, 'Gorbatchov', b'0', 1),
(3, 'Karl Marx', b'1', 1),
(4, 'Allan Kardec', b'0', 1),

(5, 'Vitiligo', b'1', 2),
(6, 'Astigmatismo', b'0', 2),
(7, 'Pedofilia', b'0', 2),
(8, 'Bruxismo', b'0', 2),

(9, 'Guilherme Tell', b'0', 3),
(10, 'Sancho Panca', b'1', 3),
(11, 'Sigmund Freud', b'0', 3),
(12, 'Lancelot', b'0', 3),

(13, 'Percussao', b'0', 4),
(14, 'Sopro', b'0', 4),
(15, 'Repercussao', b'0', 4),
(16, 'Cordas', b'1', 4),

(17, 'Rio de Janeiro', b'0', 5),
(18, 'Parana', b'0', 5),
(19, 'Santa Catarina', b'0', 5),
(20, 'Rio Grande do Sul', b'1', 5),

(21, 'Gauchinha', b'0', 6),
(22, 'Paulistinha', b'0', 6),
(23, 'Pimentinha', b'1', 6),
(24, 'Andorinha', b'0', 6),

(25, 'Nero', b'1', 7),
(26, 'Adriano', b'0', 7),
(27, 'Julio Cesar', b'0', 7),
(28, 'Brutus', b'0', 7),

(29, 'Japao', b'0', 8),
(30, 'Italia', b'1', 8),
(31, 'Chile', b'0', 8),
(32, 'Mexico', b'0', 8),

(33, 'Morumbi', b'0',9),
(34, 'Pacaembu', b'0',9),
(35, 'Maracana', b'1',9),
(36, 'Mineirao', b'0',9),

(37, 'Vulcao', b'0',10),
(38, 'Comida', b'0',10),
(39, 'Instrumento musical', b'1',10),
(40, 'Tribo indigena', b'0',10),

(41, 'DR. Zerbini', b'0',11),
(42, 'DR. Fritz', b'0',11),
(43, 'DR. Jatene', b'1',11),
(44, 'DR. Calligari', b'0',11),

(45, 'Julio Cesar', b'1',12),
(46, 'Calagola', b'0',12),
(47, 'Nero', b'0',12),
(48, 'Marco Antonio', b'0',12),

(49, 'Siria', b'0',13),
(50, 'Nepal', b'0',13),
(51, 'Mongolia', b'0',13),
(52, 'Libano', b'1',13),

(53, 'Belem', b'0',14),
(54, 'Bagda�', b'1',14),
(55, 'Beirute', b'0',14),
(56, 'Budapeste', b'0',14),

(57, 'Ronald Reagan', b'1',15),
(58, 'George Bush', b'0',15),
(59, 'Richard Nixon', b'0',15),
(60, 'Bill Clinton', b'0',15),

(61, 'Sao Jose do Rio Preto', b'0',16),
(62, 'Sao Jose dos Pinhais', b'0',16),
(63, 'Sao Jose dos Campos', b'1',16),
(64, 'Sao Jose dos Santos', b'0',16),

(65, 'Americo dos Reis', b'0',17),
(66, 'Americo Vespucio', b'1',17),
(67, 'Americo Brasiliense', b'0',17),
(68, 'Jose Americo da Silva', b'0',17),

(69, '1971', b'0',18),
(70, '1972', b'0',18),
(71, '1973', b'0',18),
(72, '1974', b'1',18),

(73, 'Polonia', b'0',19),
(74, 'Franca', b'0',19),
(75, 'Holanda', b'1',19),
(76, 'Italia', b'0',19),

(77, 'Atlantico', b'0',20),
(78, 'Pacifico', b'1',20),
(79, 'Morto', b'0',20),
(80, 'Indico', b'0',20)
;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tb_resposta`
--
ALTER TABLE `tb_resposta`
  ADD CONSTRAINT `FKpfqt1ey6jjw24kvkh7twj9kgc` FOREIGN KEY (`id_pergunta`) REFERENCES `tb_pergunta` (`id_pergunta`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
