using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Entidades
{
        public class Pacote
    {
         public int Id { get; set; }
         public string Nome { get; set; }
         public decimal Custo { get; set; }
         public int QtdQuartos { get; set; }
         public int QtdBanheiros { get; set; }
         public int QtdCozinhas { get; set; }
         public int QtdSalas { get; set; }
     }
}
