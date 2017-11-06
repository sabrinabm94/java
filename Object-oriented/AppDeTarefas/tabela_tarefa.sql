CREATE DATABASE bancoSabrina
USE bancoSabrina

CREATE TABLE `tarefa` (
  `id_tarefa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `prioridade` int(11) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `feito` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_tarefa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

SELECT * FROM tarefa


