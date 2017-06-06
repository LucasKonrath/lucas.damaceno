using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
    
namespace ImobiliariaTriVaga.Infraestrutura.Mappings
{
    public class EstoqueImovelMap : EntityTypeConfiguration<EstoqueImovel>
    {
        public EstoqueImovelMap()
        {
            ToTable("EstoqueImovel");

            HasRequired(x => x.TipoImovel)
                .WithMany()
                .HasForeignKey(x => x.IdTipoImovel);

            HasRequired(x => x.Pacote)
                .WithMany()
                .HasForeignKey(x => x.IdPacote);
        }
    }
}