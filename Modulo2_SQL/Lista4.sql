/*Exerc�cio 1

Datas

Liste todos os projetos que tiveram atrasos no in�cio da obra, exibir tamb�m o tempo previsto (em meses), e o tempo realizado (em meses) para a conclus�o da obra.
*/

SELECT PROJETO, DateDiff(MONTH,DATA_INICIO_PREV,DATA_FIM_PREV) AS [TEMPO PREVISTO EM MESES],DATEDIFF(MONTH,DATA_INICIO_REAL,DATA_FIM_REAL) AS [TEMPO REALIZADO EM MESES] FROM LICITACAO
WHERE DATA_INICIO_PREV < DATA_INICIO_REAL;

select PROFISSIONAIS, EMPRESA_LICITANTE from licitacao
/* Exerc�cio 2

Ranking

Liste as TOP 10 empresas que tiveram maior faturamento, 
deve ser projetado tamb�m o valor m�dio por profissional.
*/
select  distinct TOP 10 Empresa_Licitante, SUM(Valor_Realizado) as Faturamento, Sum(Valor_Realizado) / Sum(Profissionais) as [Valor M�dio por Profissional] 
from licitacao 
group by Empresa_Licitante
order by Faturamento desc;
/*
Exerc�cio 3

TOP Cidades

Liste as TOP 10 cidades com maior arreca��o de impostos.
*/
Select distinct  top 10 municipio, SUM(Imposto_Municipal) as [Imposto Municipal Arrecadado]
from licitacao
group by municipio
order by SUM(Imposto_Municipal) desc;

/*
Exerc�cio 4

Finais de semana

Liste todos os projetos que tiveram a data de in�cio (real) ocorrendo em finais de semana (s�bado ou domingo).
*/
Select * from licitacao
WHERE Datepart(dw, Data_Inicio_Real) = 7 OR Datepart(dw, Data_Inicio_Real) = 1

/*
Exerc�cio 5

Empresas com sorte

Liste todas as empresas que tiveram (ou ter�o) um faturamento (valor previsto) superior a 50% do seu faturamento no ano anterior.
*/
select empresa_licitante, SUM(Valor_Previsto) as [Valor Previsto Esse Ano], SUM(Faturamento_1Ano_Anterior) as [Valor Faturado Ano Passado] from licitacao 
group by Empresa_Licitante
having SUM(Valor_Previsto) > SUM(Faturamento_1Ano_Anterior) * 0.5;

/*
Exerc�cio 6

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
Exerc�cio 7

Investiga��o

O projeto 17255 foi suspenso, o motivo foi o elevado custo para o or�amento anual do munic�pio. 
A partir de uma investiga��o mais detalhada foi visto que esse motivo n�o era a verdadeira raz�o. 
Explique por que este motivo n�o � v�lido apresentando uma consulta com dados.

*/
Select * from licitacao where Identificador=17255;

-- Projeto est� muito atrasado, j� se passaram 7 meses desde a data prevista para finaliza��o e ainda n�o 
-- foi finalizado. Al�m disso, or�amento foi muito baixo ( visto que o lance do 2o colocado foi mais de 10 vezes 
-- maior).