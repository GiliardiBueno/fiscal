CREATE TABLE IF NOT EXISTS departamento (
    id INT AUTO_INCREMENT,
    emitente_id INT,
    nome_departamento VARCHAR(80),
    logradouro_departamento VARCHAR(80),
    numero_departamento VARCHAR(10),
    complemento_departamento VARCHAR(50),
    bairro_departamento VARCHAR(80),
    cep_departamento VARCHAR(12),
    telefone_departamento VARCHAR(12),
    email_departamento VARCHAR(60),
    diretor_departamento VARCHAR(50),
    PRIMARY KEY(id),
    CONSTRAINT fk_emitente_departamento FOREIGN KEY (emitente_id) REFERENCES emitente(id)
)  ENGINE=INNODB;
