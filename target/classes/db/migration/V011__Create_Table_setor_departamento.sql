CREATE TABLE IF NOT EXISTS setor_departamento (
    id INT AUTO_INCREMENT,
    departamento_id INT,
    nome_setor VARCHAR(80),
    logradouro_setor VARCHAR(80),
    numero_setor VARCHAR(10),
    complemento_setor VARCHAR(50),
    bairro_setor VARCHAR(80),
    cep_setor VARCHAR(12),
    telefone_setor VARCHAR(12),
    email_setor VARCHAR(60),
    responsavel_setor VARCHAR(50),
    PRIMARY KEY(id),
    CONSTRAINT fk_departamento_setor FOREIGN KEY (departamento_id) REFERENCES departamento(id)
)  ENGINE=INNODB;
