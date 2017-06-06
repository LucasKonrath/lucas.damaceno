using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Entidades
{
    public class EstoqueImovel
    {
        public int Id { get; set; }
        public int IdTipoImovel { get; set; }
         public TipoImovel TipoImovel { get; set; }
         public int IdPacote { get; set; }
         public Pacote Pacote { get; set; }
         public int Quantidade { get; set; }
    }
}
