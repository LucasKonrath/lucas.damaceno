-- EXERCICIO 1 - Cópia de uma tabela

--Crie a tabela CidadeAux a partir de uma cópia da tabela Cidade. Considere todos os registros existentes.
SELECT * INTO CIDADEAUX FROM CIDADE;
-- EXERCICIO 2 - Copiando dados parciais

-- Limpe a tabela CidadeAux (Truncate table CidadeAux). 
-- E em seguida insira todas os registros da tabela Cidade onde o estado seja RS.
TRUNCATE TABLE CIDADEAUX;

insert into cidadeaux
select * from cidade
where UF='RS';
select * from cidadeAux;
/* Exercício 3

Criando uma tabela

Crie uma tabela para armazenar informações de produtos. Devem ter os seguintes atributos:

Código de identificação;
Nome curto,
Nome descritivo,
Data da criação,
Local no estoque,
Quantidade e
Preço.
*/

CREATE TABLE infoProdutos (
	CodigoId int,
	nomeCurto varchar(5),
	nomeDescritivo varchar(25),
	dataDaCriacao date,
	localNoEstoque varchar(20),
	 quantidade  INTEGER,
	 preco FLOAT(2),
);


ALTER TABLE infoProdutos add constraint UK_CODIGOPRODUTO unique (CodigoId);


ALTER TABLE infoProdutos
ALTER column nomeDescritivo varchar(60)
ALTER TABLE infoProdutos
ALTER column nomeCurto varchar(35)
/*Exercício 4

Inserindo registros

Crie dois registros nessa tabela nova (produto).*/
INSERT INTO INFOPRODUTOS 
VALUES(255, 'Trafo Sulton', 'Transformador 100MA 60HZ 16V SULTON', '01/10/1996', 'ILHA 2B', 44, 322.50)
INSERT INTO INFOPRODUTOS 
VALUES(232, 'PIC', 'MICROPROCESSADOR 16 BITS 16F690', '27/04/2017', 'ILHA 5A', 0, 16.25)
SELECT * FROM INFOPRODUTOS;
SELECT * FROM CIDADEAUX;