CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT,
    nome VARCHAR(14) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    matricula VARCHAR(8) NOT NULL,
    foto VARCHAR(100),
    celular VARCHAR(14),
    login VARCHAR(20) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    status TINYINT NOT NULL,
    tipouser INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_tipo_usuario FOREIGN KEY (tipouser) REFERENCES tipousuario (id)
)  ENGINE=INNODB;