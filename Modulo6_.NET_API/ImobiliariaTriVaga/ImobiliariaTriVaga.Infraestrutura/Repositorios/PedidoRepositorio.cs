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
            pedido.TipoImovel = estoqueImovelRepositorio.ObterTipoDeImovelPorId(pedido.IdTipoImovel, contextoOriginal);
            pedido.Pacote = estoqueImovelRepositorio.ObterTamanhoPorId(pedido.IdPacote, contextoOriginal);
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
            var estoqueDoImovel = contexto.EstoqueImovel
                .Where(item => item.IdTipoImovel == pedido.IdTipoImovel
                        && item.IdPacote == pedido.IdPacote).FirstOrDefault();
            estoqueDoImovel.Quantidade += 1;

            var adicionais = contexto.PedidoAdicional.
               Where(pedidoSelecionado => pedidoSelecionado.IdPedido == pedido.Id).
               ToList();

            foreach (var adicional in adicionais)
            {

                var adicionalSelect = contexto.Adicionais.Where(adicionalRetornar => adicional.IdAdicional == 
                adicionalRetornar.Id).FirstOrDefault();
                adicionalSelect.Estoque += 1;

            }
            var adicionaisDaTabelaARemover = contexto.PedidoAdicional.Where(itens => itens.IdPedido == pedido.Id).ToList();
            foreach(var adicional in adicionaisDaTabelaARemover)
            {
                contexto.PedidoAdicional.Remove(adicional);
            }
         
            contexto.Pedidos.Remove(pedido);  
            contexto.SaveChanges();
        }

        public Pedido Retornar(int id)
        {
            Pedido pedido = Obter(id);

            var estoqueDoImovel = contexto.EstoqueImovel
               .Where(item => item.IdTipoImovel == pedido.IdTipoImovel
                       && item.IdPacote == pedido.IdPacote).FirstOrDefault();
            estoqueDoImovel.Quantidade += 1;

            pedido.Adicionais = contexto.PedidoAdicional.
             Where(pedidoSelecionado => pedidoSelecionado.IdPedido == pedido.Id).
             ToList();

            foreach (var adicional in pedido.Adicionais)
            {

                var adicionalSelect = contexto.Adicionais.Where(adicionalRetornar => adicional.IdAdicional ==
                adicionalRetornar.Id).FirstOrDefault();
                adicionalSelect.Estoque += 1;

            }
   
            contexto.SaveChanges();
            pedido.Adicionais = null;
            return pedido;
        }

        public dynamic cancelarDevolucao(int id)
        {
            var pedidoSelecionado = contexto.Pedidos.Where(pedido => pedido.Id == id).FirstOrDefault();
            pedidoSelecionado.DataEntregaRealizada = null;
            pedidoSelecionado.TotalASerPago = null; 
            contexto.SaveChanges();
            return pedidoSelecionado.DataEntregaRealizada;
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

            var adicionais = contexto.PedidoAdicional.
                Where(pedido => pedido.IdPedido == pedidoARetornar.Id).
                ToList();

            foreach(var adicional in adicionais)
            {

                var adicionalSelect = contexto.Adicionais.Where(adicionalRetornar => adicional.IdAdicional == adicionalRetornar.Id).FirstOrDefault();
                pedidoARetornar.TotalPorDia += adicionalSelect.Custo;

            }
            pedidoARetornar.Adicionais = null;
            pedidoARetornar.DataEntregaRealizada = DateTime.Now;
            if (pedidoARetornar.DataVenda == null) return pedidoARetornar;
            TimeSpan? dataCalcular = (pedidoARetornar.DataEntregaRealizada.Value.Date.Subtract(pedidoARetornar.DataVenda.Value.Date));
            pedidoARetornar.TotalASerPago = (decimal)(dataCalcular.Value.TotalDays) * pedidoARetornar.TotalPorDia;
            return pedidoARetornar;
        }
    }
}