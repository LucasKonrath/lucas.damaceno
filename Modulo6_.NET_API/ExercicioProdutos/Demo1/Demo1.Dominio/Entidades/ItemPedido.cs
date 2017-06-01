using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class ItemPedido
    {

        public ItemPedido(int ID, int produtoId, int quantidade)
        {
            Id = ID;
            ProdutoId = produtoId;
            Quantidade = quantidade;


        }
        public int Id { get; set; }
        public int ProdutoId { get; set; }
        public int Quantidade { get; set; }

   

    }
}
