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
	CodigoId int identity not null,
	nomeCurto varchar(25) not null,
	nomeDescritivo varchar(60) not null,
	dataDaCriacao date not null,
	localNoEstoque varchar(20) not null,
	 quantidade  INTEGER not null,
	 preco FLOAT(2) not null,
);


ALTER TABLE infoProdutos add constraint PK_CODIGOPRODUTO PRIMARY KEY (CodigoId);



ALTER TABLE INFOPRODUTOS
ALTER COLUMN quantidade decimal(7,3) not null;
ALTER TABLE INFOPRODUTOS
ALTER COLUMN preco decimal(9,2) not null;
/*Exercício 4

Inserindo registros

Crie dois registros nessa tabela nova (produto).*/
INSERT INTO INFOPRODUTOS 
VALUES( 'Trafo Sulton', 'Transformador 100MA 60HZ 16V SULTON', '01/10/1996', 'ILHA 2B', 44, 322.50)
INSERT INTO INFOPRODUTOS 
VALUES( 'PIC', 'MICROPROCESSADOR 16 BITS 16F690', '27/04/2017', 'ILHA 5A', 0, 16.25)
SELECT * FROM INFOPRODUTOS;
SELECT * FROM CIDADEAUX;
INSERT INTO INFOPRODUTOS
VALUES('CLS100', 'central de alarme cls100', getdate(),'ILHA 4C',22.5,32.17)

