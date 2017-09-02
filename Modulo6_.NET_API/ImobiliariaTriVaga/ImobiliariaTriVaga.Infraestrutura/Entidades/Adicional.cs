using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Entidades
{
    public class Adicional
     {
         public int Id { get; set; }
         public string Nome { get; set; }
         public decimal Custo { get; set; }

        public int Estoque { get; set; }
     }
}
