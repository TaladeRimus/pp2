CREATE TABLE usuario(
idUsuario SERIAL PRIMARY KEY,
permissao_usuario integer,
nome varchar(100),
endereco varchar(100),
cpf integer,
rg integer,
login varchar(20),
senha varchar(10)
);

CREATE TABLE produto (
idProduto SERIAL PRIMARY KEY,
nome varchar(100),
quantidade_total integer,
preco decimal(10,2)
);


CREATE TABLE venda (
idVenda SERIAL PRIMARY KEY,
idUsuarioFK integer,
idProdutoFK integer,
quantidade_produto integer
);

ALTER TABLE venda ADD FOREIGN KEY (idUsuarioFK) REFERENCES usuario(idUsuario);
ALTER TABLE venda ADD FOREIGN KEY (idProdutoFK) REFERENCES produto(idProduto);

SELECT * FROM venda;
