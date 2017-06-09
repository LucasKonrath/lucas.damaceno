using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();
        private AdicionalRepositorio adicionalRepositorio = new AdicionalRepositorio();
        private EstoqueImovelRepositorio estoqueImovelRepositorio = new EstoqueImovelRepositorio();
        public PedidoRepositorio()
        {

        }

        public void Dispose()
        {
            contexto.Dispose();

        }

        public Pedido Criar(Pedido pedido, Contexto contextoOriginal)
        {
            
            pedido.TotalPorDia = 0;
            pedido.DataVenda = DateTime.Now;
            pedido.TipoImovel = estoqueImovelRepositorio.ObterTipoDeImovelPorId(pedido.IdTipoImovel);
            pedido.Pacote = estoqueImovelRepositorio.ObterTamanhoPorId(pedido.IdPacote);
            pedido.TotalPorDia += (pedido.TipoImovel.Preco + pedido.Pacote.Custo);
            estoqueImovelRepositorio.descontarDoEstoque(pedido.IdTipoImovel, pedido.IdPacote,contextoOriginal);
            contextoOriginal.Pedidos.Add(pedido);
            
            foreach (var itemAdicional in pedido.Adicionais)
            {
                itemAdicional.Pedido = pedido;
                itemAdicional.Adicional = adicionalRepositorio.ObterPorId(itemAdicional.IdAdicional);
                contextoOriginal.Entry(itemAdicional.Adicional).State = EntityState.Unchanged;
            }

            return adicionalRepositorio.AdicionarLista(pedido);
           
        }

        public object ObterTodosPedidos()
        {
            return contexto.Pedidos
                .Include("Pacote")
                .Include("Cliente")
                .Include("TipoImovel")
                .ToList();
        }

        

        public void Deletar(int id)
        {
            Pedido pedido = Obter(id);
            contexto.Pedidos.Remove(pedido);  
            contexto.SaveChanges();
        }

        public dynamic Obter(int id)
        {
           var pedidoARetornar = contexto.
                Pedidos
                .Include("Pacote")
                .Include("Cliente")
                .Include("TipoImovel")
                .Where(pedido => pedido.Id == id)
                .FirstOrDefault();

            pedidoARetornar.DataEntregaRealizada = DateTime.Now;
            TimeSpan? dataCalcular = (pedidoARetornar.DataEntregaRealizada.Value.Subtract(pedidoARetornar.DataVenda.Value));
            pedidoARetornar.TotalASerPago = (decimal)(dataCalcular.Value.TotalDays) * pedidoARetornar.TotalPorDia;
            return pedidoARetornar;
        }
    }
}