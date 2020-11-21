CREATE TABLE IF NOT EXISTS notificacao(
    id INT AUTO_INCREMENT,
    fiscal_id INT,
    tpnotificacao_id INT,
    imovel_id INT,
    data_hora_emissao TIMESTAMP,
    observacao TEXT,
    vencimento date,
    nome_notificado VARCHAR(50),
    cpf_notificado VARCHAR(20),
    assinou VARCHAR(10) ,
    foto_notificacao VARCHAR(100),
    status CHAR(1),
    PRIMARY KEY(id),
    CONSTRAINT fk_fiscal_notificacao FOREIGN KEY (fiscal_id) REFERENCES usuario(id),
    CONSTRAINT fk_tipo_notificacao FOREIGN KEY (tpnotificacao_id) REFERENCES tipo_notificacao(id),
    CONSTRAINT fk_setor_dpto FOREIGN KEY (imovel_id) REFERENCES imovel(id)
)  ENGINE=INNODB;

    


