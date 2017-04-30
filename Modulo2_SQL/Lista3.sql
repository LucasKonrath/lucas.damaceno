/*Datas

Fa�a uma consulta que liste o total de empregados admitidos no ano de 1980. Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admiss�o.
*/
 select IDEmpregado as ID, NomeEmpregado as Nome, FLOOR(DATEDIFF(Year,DataNascimento, DataAdmissao)) as [Idade no momento de Admiss�o(em 1980)] from empregado WHERE YEAR(DataAdmissao) = 1980;

 /*
 Exerc�cio 2

Ranking

Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. ** DICA: Pesquise recursos espec�ficos para esta funcionalidade.
*/
SELECT Top 1 Count( Cargo) as QtdCargo,Cargo  FROM EMPREGADO Group BY Cargo ORDER BY  QtdCargo DESC;


/*
Exerc�cio 3

Contagem

Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
*/
Select UF as Estado, Count(NOME)
FROM CIDADE
GROUP BY UF
ORDER BY COUNT(NOME) DESC;

/*
Exerc�cio 4

Alterando dados

Crie um novo departamento, denominado 'Inova��o' com localiza��o em 'S�O LEOPOLDO'. Todos os empregados que foram admitidos no m�s de dezembro (qualquer ano) que n�o ocupam o cargo de 'Atendente' devem ser ter o departamento (IDDepartamento) atualizado para este novo registro (inova��o).

*/

INSERT INTO DEPARTAMENTO 
VALUES(70,'Inova��o','SAO LEOPOLDO');


UPDATE EMPREGADO 
SET IDDepartamento = 70
WHERE CARGO != 'ATENDENTE' AND DatePART(Month,DataAdmissao) = 12;

SELECT * FROM EMPREGADO;