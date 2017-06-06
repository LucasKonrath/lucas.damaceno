using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Mappings
{
    public class PedidoMap : EntityTypeConfiguration<Pedido>
    {

        public PedidoMap()
        {
            ToTable("Pedidos");

            HasRequired(pedido => pedido.TipoImovel)
                 .WithMany()
                 .HasForeignKey(pedido => pedido.IdTipoImovel);

            HasRequired(pedido => pedido.Pacote)
                .WithMany()
               .HasForeignKey(pedido => pedido.IdPacote);


            HasMany(pedido => pedido.Adicionais).WithMany()
                .Map(pedido =>
                 {
                pedido.MapLeftKey("IdPedido");
                pedido.MapRightKey("IdAdicional");
                pedido.ToTable("PedidoAdicional");
                                });


            HasRequired(x => x.Cliente)
                 .WithMany()
                 .HasForeignKey(x => x.IdCliente);
        }

    }
}
