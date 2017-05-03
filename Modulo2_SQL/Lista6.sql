/*
Exercicio 1

Primeiro nome

Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.

Exemplo de resultado esperado:

PrimeiroNome	TotalOcorrencias
Juvenita	7

*/


SELECT TOP 1 
LEFT([Nome],CHARINDEX(' ',[Nome] + ' ')-1)  AS [Primeiro Nome],
Count(1) AS [Total de Ocorrências]
FROM CLIENTE
GROUP BY (LEFT([Nome],CHARINDEX(' ',[Nome] + ' ')-1))
ORDER BY Count(1)DESC;

/*

Exercício 2

Total do Mês

Liste o total de pedidos (quantidade e valor) realizados no mês de abril/2017.

Exemplo de resultado esperado:

Quantidade	ValorPedido
469	22,817,022.06

*/




SELECT COUNT(1) AS QUANTIDADE, SUM(ValorPedido) as ValorPedido  
FROM PEDIDO
WHERE DatePart(Month,Datapedido) = 4 AND DatePart(Year,DataPedido) = 2017


/*

Exercício 3

Estados x Clientes

Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente), liste também qual o Estado possuí o menor número de clientes.

Exemplo de resultado esperado:

UF	TotalClientes
AC	24
MG	2008

*/

SELECT top 1 Cidade.UF as UF, Count(1) as TotalClientes
FROM Cliente
INNER JOIN CIDADE ON Cliente.IDCidade = Cidade.IDCidade
Group by UF
Order by Count(1) ASC

SELECT TOP 1 Cidade.UF as UF, Count(1) as TotalClientes
FROM Cliente
INNER JOIN CIDADE ON Cliente.IDCidade = Cidade.IDCidade
Group by UF
ORDER BY Count(1) DESC







/*

Exercício 4

Novo Produto

Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:

Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A

*/
BEGIN TRANSACTION

Insert into Produto(Nome, PrecoCusto, PrecoVenda, Situacao)
Values ('Galocha Maragato', 35.67, 77.95,'A')

COMMIT

/*

Exercício 5

Produtos não comprados

Identifique e liste os produtos que não tiveram nenhum pedido, 
considere os relacionamentos no modelo de dados, pois não há 
relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).

=> Obs.: o produto criado anteriormente deverá ser listado (apenas este)

*/

select * from Produto WHERE IDproduto NOT IN (Select DISTINCT IDProduto from PedidoItem)

/*

Exercício 6

Principais Produtos

Liste os 30 produtos que mais geraram lucro em 2016.

*/
select * from Pedido
SELECT TOP 30 Produto.Nome, Produto.IDProduto,((Produto.PrecoVenda - Produto.PrecoCusto) * (SUM(PedidoItem.Quantidade))) as Lucro  
FROM PRODUTO
INNER JOIN PedidoItem ON Produto.IDProduto = PedidoItem.IDProduto AND PedidoItem.IDPedido IN (SELECT IDPedido FROM Pedido WHERE DATEPART(YEAR,DataPedido) = 2016)
group by Produto.Nome, Produto.IDProduto, Produto.PrecoCusto, Produto.PrecoVenda
order by Lucro desc;
