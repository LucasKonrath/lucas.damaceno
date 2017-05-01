/*Exercício 1

Datas

Liste todos os projetos que tiveram atrasos no início da obra, exibir também o tempo previsto (em meses), e o tempo realizado (em meses) para a conclusão da obra.
*/

SELECT PROJETO, DateDiff(MONTH,DATA_INICIO_PREV,DATA_FIM_PREV) AS [TEMPO PREVISTO EM MESES],DATEDIFF(MONTH,DATA_INICIO_REAL,DATA_FIM_REAL) AS [TEMPO REALIZADO EM MESES] FROM LICITACAO
WHERE DATA_INICIO_PREV < DATA_INICIO_REAL;

select PROFISSIONAIS, EMPRESA_LICITANTE from licitacao
/* Exercício 2

Ranking

Liste as TOP 10 empresas que tiveram maior faturamento, 
deve ser projetado também o valor médio por profissional.
*/
select  distinct TOP 10 Empresa_Licitante, SUM(Valor_Realizado) as Faturamento, Sum(Valor_Realizado) / Sum(Profissionais) as [Valor Médio por Profissional] 
from licitacao 
group by Empresa_Licitante
order by Faturamento desc;
/*
Exercício 3

TOP Cidades

Liste as TOP 10 cidades com maior arrecação de impostos.
*/
Select distinct  top 10 municipio, SUM(Imposto_Municipal) as [Imposto Municipal Arrecadado]
from licitacao
group by municipio
order by SUM(Imposto_Municipal) desc;

/*
Exercício 4

Finais de semana

Liste todos os projetos que tiveram a data de início (real) ocorrendo em finais de semana (sábado ou domingo).
*/
Select * from licitacao
WHERE Datepart(dw, Data_Inicio_Real) = 7 OR Datepart(dw, Data_Inicio_Real) = 1

/*
Exercício 5

Empresas com sorte

Liste todas as empresas que tiveram (ou terão) um faturamento (valor previsto) superior a 50% do seu faturamento no ano anterior.
*/
select empresa_licitante, SUM(Valor_Previsto) as [Valor Previsto Esse Ano], SUM(Faturamento_1Ano_Anterior) as [Valor Faturado Ano Passado] from licitacao 
group by Empresa_Licitante
having SUM(Valor_Previsto) > SUM(Faturamento_1Ano_Anterior) * 0.5;

/*
Exercício 6

Custo real

Liste os projetos exibindo o custo real do projeto. 
Caso o projeto seja de esfera federal deve ser descontado o imposto federal, 
e assim respectivamente para as esferas estaduais e municipais.
*/

Select *, CustoReal =

	CASE 
	WHEN Esfera = 'FEDERAL' THEN (VALOR_REALIZADO - IMPOSTO_FEDERAL)
	WHEN Esfera = 'Municipal' then (VALOR_REALIZADO - IMPOSTO_MUNICIPAL)
	WHEN Esfera = 'Estadual' then (Valor_Realizado - Imposto_Estadual)
	END
	FROM LICITACAO;
/*
Exercício 7

Investigação

O projeto 17255 foi suspenso, o motivo foi o elevado custo para o orçamento anual do município. 
A partir de uma investigação mais detalhada foi visto que esse motivo não era a verdadeira razão. 
Explique por que este motivo não é válido apresentando uma consulta com dados.

*/
Select * from licitacao where Identificador=17255;

-- Projeto está muito atrasado, já se passaram 7 meses desde a data prevista para finalização e ainda não 
-- foi finalizado. Além disso, orçamento foi muito baixo ( visto que o lance do 2o colocado foi mais de 10 vezes 
-- maior).