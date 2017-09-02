UPDATE EMPREGADO 
SET COMISSAO=0
WHERE COMISSAO IS NULL;
-- Ex 1. Selecionar empregados em ordem de admissão.
select IDEmpregado AS ID, NomeEmpregado as NOME FROM Empregado ORDER BY DataAdmissao ASC;
--Ex.2  Selecionar empregados que não recebem comissão em ordem de admissão.
select * FROM Empregado WHERE Comissao=0  ORDER BY DataAdmissao ASC;
-- Ex. 3 
/*
Cálculo

Faça uma consulta que retorno o nome dos empregados, o salário anual (considere 13 salários), projete também a comissão (considere 12x). As colunas que deverão ser exibidas são:

ID do Empregado
Nome
Salario Anual
Comissão Anual
Renda Anual
*/

SELECT IDEmpregado as ID, NomeEmpregado as Nome, (salario*13) as [Salario Anual],(comissao*12) as [Comissao Anual],(salario*13 + comissao*12) as [Renda Anual]
FROM EMPREGADO 
-- EX 4
/*
Exercício 4

Cálculo e Filtros

Faça uma consulta que liste todos os empregados que tenham o salário anual seja inferior a R$ 18500 ou que tenham o cargo de Atendente. Projetar as seguintes colunas:

ID do Empregado
Nome
Cargo
Salário Mensal
*/
SELECT IDEmpregado as [ID do Empregado],NomeEmpregado as Nome,Cargo,Salario as [Salário Mensal]
FROM EMPREGADO 
WHERE (salario*12) < 18500 OR Cargo='Atendente';