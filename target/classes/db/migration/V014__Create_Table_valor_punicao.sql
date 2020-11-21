CREATE TABLE IF NOT EXISTS valor_notificacao(
    id INT AUTO_INCREMENT,
    notifica_id INT,
    multa decimal(10,2),
    servico decimal(10,2),
    total decimal(10,2),
    PRIMARY KEY(id),
    CONSTRAINT fk_valor_notifica FOREIGN KEY (notifica_id) REFERENCES notificacao(id)
)  ENGINE=INNODB;
