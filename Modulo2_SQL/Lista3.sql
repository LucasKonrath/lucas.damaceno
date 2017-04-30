/*Datas

Faça uma consulta que liste o total de empregados admitidos no ano de 1980. Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admissão.
*/
 select IDEmpregado as ID, NomeEmpregado as Nome, FLOOR(DATEDIFF(Year,DataNascimento, DataAdmissao)) as [Idade no momento de Admissão(em 1980)] from empregado WHERE YEAR(DataAdmissao) = 1980;

 /*
 Exercício 2

Ranking

Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. ** DICA: Pesquise recursos específicos para esta funcionalidade.
*/
SELECT Top 1 Count( Cargo) as QtdCargo,Cargo  FROM EMPREGADO Group BY Cargo ORDER BY  QtdCargo DESC;


/*
Exercício 3

Contagem

Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
*/
Select UF as Estado, Count(NOME)
FROM CIDADE
GROUP BY UF
ORDER BY COUNT(NOME) DESC;

/*
Exercício 4

Alterando dados

Crie um novo departamento, denominado 'Inovação' com localização em 'SÃO LEOPOLDO'. Todos os empregados que foram admitidos no mês de dezembro (qualquer ano) que não ocupam o cargo de 'Atendente' devem ser ter o departamento (IDDepartamento) atualizado para este novo registro (inovação).

*/

INSERT INTO DEPARTAMENTO 
VALUES(70,'Inovação','SAO LEOPOLDO');


UPDATE EMPREGADO 
SET IDDepartamento = 70
WHERE CARGO != 'ATENDENTE' AND DatePART(Month,DataAdmissao) = 12;

SELECT * FROM EMPREGADO;