/* 

Exercício 1

Múltiplos acessos

Liste o nome do empregado, o nome do gerente e o departamento de cada um.
*/

SELECT Empregado.NomeEmpregado, g.NomeEmpregado as NomeGerente, Empregado.IDDepartamento as [Departamento do Empregado], G.IDDepartamento as [Departamento Do Gerente]  
FROM EMPREGADO 
INNER JOIN Empregado g ON Empregado.IDGerente = g.IDEmpregado

/* 
Exercício 2

Maior Salário

Liste o deparamento (id e nome) com o empregado de maior salário.
*/
SELECT Departamento.IDDepartamento, Departamento.NomeDepartamento
FROM Departamento
INNER JOIN Empregado ON Departamento.IDDepartamento = Empregado.IDDepartamento
WHERE Empregado.Salario = (Select MAX(Salario) from Empregado where IDDepartamento IS NOT NULL)

SELECT * FROM EMPREGADO
WHERE SALARIO = (Select MAX(Salario) from Empregado WHERE IDDepartamento IS NOT NULL)

/*

Exercício 3

Reajuste salarial

Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, 
este reajuste deve ser de 17,3%. 
Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa.

*/

SELECT * INTO CopiaEmpregado FROM Empregado

UPDATE EMPREGADO
SET SALARIO = SALARIO * 1.173
FROM EMPREGADO
INNER JOIN DEPARTAMENTO ON EMPREGADO.IDDepartamento = DEPARTAMENTO.IDDepartamento
WHERE Departamento.Localizacao = 'SAO PAULO'

/*

Exercício 4

Cidades duplicadas

Liste todas as cidades duplicadas (nome e UF iguais).

*/

(
SELECT COUNT(1) as [Quantidade de Cidades Iguais],Nome as [Nome Da Cidade], UF as [Unidade Federativa] FROM CIDADE 
GROUP BY Nome,uf
having COUNT(1) >= 2
)

/*

Exercício 5

Definindo Cidades

Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. 
Mas atenção! apenas a cidade com maior ID deve ser alterada.

*/

BEGIN TRANSACTION
UPDATE CIDADE 
SET Nome = Nome + '*'
WHERE Nome IN (SELECT Nome as [Nome Da Cidade] FROM CIDADE 
GROUP BY Nome
having COUNT(1) >= 2) AND IDCidade in 
(SELECT MAX(IDCidade) FROM CIDADE GROUP BY NOME HAVING NOME = CIDADE.NOME)

SELECT * FROM CIDADE ORDER BY NOME DESC;
COMMIT

