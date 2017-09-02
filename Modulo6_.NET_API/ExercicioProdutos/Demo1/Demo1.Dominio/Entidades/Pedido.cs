using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public string NomeCliente { get; set; }
        public List<ItemPedido> Itens { get; set; }

        public bool Validar(out List<string> mensagens)
        {
             mensagens = new List<string>();
 
             if (NomeCliente.Length < 1)
                 mensagens.Add("Nome do cliente é obrigatorio.");
 
             if (Itens.Where(i => i.Quantidade< 0).Any())
                 mensagens.Add("Não é possível gerar pedidos com itens com quantia negativa.");
 
             return mensagens.Count() == 0;
        }


}
}
