using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Repositorios
{
    public class AdicionalRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();


        public AdicionalRepositorio()
        {

        }

        public Adicional ObterPorId(int id)
        {
            return contexto.Adicionais.Where(x => x.Id == id).FirstOrDefault();
        }
        public List<Adicional> ObterAdicionais()
        {
            return contexto.Adicionais.ToList();
        }
        public void Dispose()
        {
            contexto.Dispose();

        }

        internal Pedido AdicionarLista(Pedido pedido)
        {
            foreach(var adicional in pedido.Adicionais)
            {
                if (adicional.Quantidade > adicional.Adicional.Estoque)
                    throw new Exception("Estoque ficaria menor do que 0");
                adicional.Adicional.Estoque -= adicional.Quantidade;
                //PedidoAdicional pedidoAdd = new PedidoAdicional();
                //pedidoAdd.IdAdicional = adicional.Adicional.Id;
                //pedidoAdd.IdPedido = pedido.Id;
                //pedidoAdd.Quantidade = adicional.Quantidade;
                //contexto.PedidoAdicional.Add(pedidoAdd);
                //pedido.TotalASerPago += pedidoAdd.Adicional.Custo * adicional.Quantidade;
            }
            contexto.SaveChanges();
            return pedido;
        }
    }
}