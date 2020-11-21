CREATE TABLE IF NOT EXISTS emitente (
    id INT AUTO_INCREMENT,
    nome_emitente VARCHAR(80),
    cnpj_emitente VARCHAR(20),
    logradouro_emitente VARCHAR(80),
    numero_emitente VARCHAR(10),
    complemento_emitente VARCHAR(50),
    bairro_emitente VARCHAR(80),
    cep_emitente VARCHAR(12),
    telefone_emitente VARCHAR(12),
    email_emitente VARCHAR(60),
    logo_emitente VARCHAR(100),
    PRIMARY KEY(id)
)  ENGINE=INNODB;
		
