CREATE TABLE IF NOT EXISTS tipo_notificacao(
    id INT AUTO_INCREMENT,
    setor_id INT,
    nome VARCHAR(60),
    textopadrao TEXT,
    prazo INT,
    PRIMARY KEY(id),
    CONSTRAINT fk_setor_tiponotificacao FOREIGN KEY (setor_id) REFERENCES setor_departamento(id)
)  ENGINE=INNODB;

