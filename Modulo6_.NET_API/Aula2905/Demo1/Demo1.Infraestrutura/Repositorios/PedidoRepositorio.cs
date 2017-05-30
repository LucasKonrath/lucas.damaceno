using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {

        string stringConexao = @"Server=13.65.101.67;
                                     User Id=lucas.damaceno;
                                     Password=123456;
                                     Database=aluno21db";

        public void Alterar(Pedido pedido)
        {

           using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"UPDATE PRODUTO SET NomeCliente = @nomeCliente WHERE Id = @id";

                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@id", pedido.Id);
                    comando.ExecuteNonQuery();
                }
            }
          
        }

        public void Criar(Pedido pedido)
        {
            // realizar o insert do Pedido
            // obter o ultimo id do pedido (SELECT @@IDENTITY)
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {

                    comando.CommandText = @"INSERT INTO Pedido(NomeCliente) 
                                                        VALUES (@nomeCliente)";
                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    //Executa o comando e retorna quantidade de linhas afetadas.
                    comando.ExecuteNonQuery();
               
                }


                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;

                }

                using (var comando = conexao.CreateCommand())
                {
                    

                    foreach (ItemPedido item in pedido.Itens)
                    {
                        comando.CommandText = @"INSERT INTO ItemPedido (PedidoID, ProdutoID, Quantidade)
                                                VALUES(@pedidoID, @produtoID, @quantidade)";
                        comando.Parameters.AddWithValue("@pedidoID", pedido.Id);
                        comando.Parameters.AddWithValue("@produtoID", item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);
                        comando.ExecuteNonQuery();
                        comando.Parameters.Clear();

                        comando.CommandText = "SELECT @@IDENTITY";
                        var resultado = (decimal)comando.ExecuteScalar();
                        item.Id = (int)resultado;
                    }

                }

              


            }
            // para cada item do pedido, realizar o insert do ItemPedido
            // obter o ultimo id do ItemPedido (SELECT @@IDENTITY)
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o DELETE
                using (var comando = conexao.CreateCommand())
                {

                    comando.CommandText = "Delete ItemPedido WHERE PedidoId = @id";

                    comando.Parameters.AddWithValue("@id", id);
                    comando.ExecuteNonQuery();

                    comando.CommandText = "DELETE Pedido WHERE Id = @idPedido";

                    comando.Parameters.AddWithValue("@idPedido", id);
                    comando.ExecuteNonQuery();
              
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {




            using (var conexao = new SqlConnection(stringConexao))
            {
                List<Pedido> ListaDePedidos = new List<Pedido>();

                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {

                    comando.CommandText =
                        @"SELECT Pedido.ID as ID, Pedido.NomeCliente as NomeCliente, ItemPedido.ProdutoId as ProdutoId, ItemPedido.Quantidade as Quantidade
                        FROM Pedido
                        INNER JOIN ItemPedido ON Pedido.ID = ItemPedido.PedidoId";



                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        Pedido pedido = new Pedido();
                        pedido.Itens = new List<ItemPedido>();
                        pedido.Id = (int)dataReader["ID"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        int IdPedidoNovo = (int)dataReader["ID"];
                        int IdProduto = (int)dataReader["ProdutoId"];
                        int QuantidadeProduto = (int)dataReader["Quantidade"];
                        ItemPedido novoItem = new ItemPedido(IdPedidoNovo, IdProduto, QuantidadeProduto);
                        pedido.Itens.Add(novoItem);
                        ListaDePedidos.Add(pedido);

                    }
                    return ListaDePedidos;
                }





            }
        }
        public Pedido Obter(int id)
        {
            
            using (var conexao = new SqlConnection(stringConexao))
            {
                Pedido pedido = new Pedido();
                pedido.Itens = new List<ItemPedido>();
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {

                    comando.CommandText = 
                        @"SELECT Pedido.ID as ID, Pedido.NomeCliente as NomeCliente, ItemPedido.ProdutoId as ProdutoId, ItemPedido.Quantidade as Quantidade
                        FROM Pedido
                        INNER JOIN ItemPedido ON Pedido.ID = ItemPedido.PedidoId
                         WHERE Pedido.ID = @id";
                    comando.Parameters.AddWithValue("@id", id);


                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        pedido.Id = (int)dataReader["ID"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];

                        int IdPedidoNovo = (int)dataReader["ID"];
                        int IdProduto = (int)dataReader["ProdutoId"];
                        int QuantidadeProduto = (int)dataReader["Quantidade"];
                        ItemPedido novoItem = new ItemPedido(IdPedidoNovo, IdProduto, QuantidadeProduto);
                        pedido.Itens.Add(novoItem);
                        

                    }
                    return pedido;
                }
                
            }
           
        }


    }
    
}
