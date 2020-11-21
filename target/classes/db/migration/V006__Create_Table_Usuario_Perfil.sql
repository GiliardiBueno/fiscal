CREATE TABLE usuario_perfil(
 id INT AUTO_INCREMENT NOT NULL,
 usuario_id INT NOT NULL,
 perfil_id  INT NOT NULL,
 PRIMARY KEY(id),
 CONSTRAINT fk_usuario_id FOREIGN KEY(usuario_id) REFERENCES usuario(id),
 CONSTRAINT fk_perfil_id FOREIGN KEY(perfil_id) REFERENCES perfil(id)
)ENGINE=INNODB;
