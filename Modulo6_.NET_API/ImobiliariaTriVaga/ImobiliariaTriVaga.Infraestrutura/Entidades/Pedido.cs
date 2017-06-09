using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Entidades
{
    public class Pedido
    {

        public int Id { get; set; }

        public int IdCliente { get; set; }

        public Cliente Cliente { get; set; }

        public DateTime? DataVenda { get; set; }

        public DateTime DataEntregaPrevista { get; set; }

        public int IdTipoImovel { get; set; }

        public TipoImovel TipoImovel { get; set; }

        public int IdPacote { get; set; }

        public Pacote Pacote { get; set; }
        public List<PedidoAdicional> Adicionais { get; set; }
        public DateTime? DataEntregaRealizada { get; set; }

        public decimal? TotalASerPago { get; set; }

        public decimal? TotalPorDia { get; set; }

        
    }
}
