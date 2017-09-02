using ImobiliariaTriVaga.Infraestrutura.Entidades;
using ImobiliariaTriVaga.Infraestrutura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura
{
    public class Contexto : DbContext
            
    {

        public Contexto() : base("name=EFSP")
        { }

        public DbSet<Adicional> Adicionais { get; set; }

        public DbSet<Cliente> Clientes { get; set; }

        public DbSet<Pacote> Pacotes { get; set; }

        public DbSet<Pedido> Pedidos { get; set; }
        public DbSet<Permissao> Permissao { get; set; }
        public DbSet<TipoImovel> TiposImoveis { get; set; } 
        public DbSet<Usuario> Usuarios { get; set; }

        public DbSet<PedidoAdicional> PedidoAdicional { get; set; }
        public DbSet<EstoqueImovel> EstoqueImovel { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AdicionalMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new PacoteMap());
            modelBuilder.Configurations.Add(new PedidoMap());
            modelBuilder.Configurations.Add(new TipoImovelMap());
            modelBuilder.Configurations.Add(new EstoqueImovelMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new PedidoAdicionalMap());
        }


    }
}