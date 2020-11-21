CREATE TABLE IF NOT EXISTS imovel (
    id INT AUTO_INCREMENT,
    nome_contribuinte VARCHAR(80),
    cpf_contribuinte VARCHAR(20),
    logradouro_imovel VARCHAR(80),
    numero_imovel VARCHAR(10),
    complemento_imovel VARCHAR(50),
    cep_imovel VARCHAR(12),
    bairro_imovel VARCHAR(80),
    setor VARCHAR(5),
    quadra VARCHAR(5),
    lote VARCHAR(8),
    logradouro_contribuinte VARCHAR(80),
    numero_contribuinte VARCHAR(10),
    complemento_contribuinte VARCHAR(50),
    bairro_contribuinte VARCHAR(80),
    cep_contribuinte VARCHAR(12),
    cidade_contribuinte VARCHAR(50),
    valor_venal_edificacao VARCHAR(12),
    valor_venal_terreno VARCHAR(12),
    valor_venal_imovel VARCHAR(12),
    total_area_edificada VARCHAR(12),
    area_terreno VARCHAR(12),
    PRIMARY KEY(id)
)  ENGINE=INNODB;
		

