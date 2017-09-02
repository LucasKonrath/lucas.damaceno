namespace ImobiliariaTriVaga.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriarBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Adicionais",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Custo = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Cpf = c.String(),
                        Genero = c.String(),
                        Nome = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                        Email = c.String(),
                        Endereco = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pacotes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Custo = c.Decimal(nullable: false, precision: 18, scale: 2),
                        QtdQuartos = c.Int(nullable: false),
                        QtdBanheiros = c.Int(nullable: false),
                        QtdCozinhas = c.Int(nullable: false),
                        QtdSalas = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdCliente = c.Int(nullable: false),
                        DataVenda = c.DateTime(nullable: false),
                        DataEntregaPrevista = c.DateTime(nullable: false),
                        IdTipoImovel = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                        DataEntregaRealizada = c.DateTime(),
                        TotalASerPago = c.Decimal(nullable: false, precision: 18, scale: 2),
                        TotalPorDia = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacotes", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.TiposImoveis", t => t.IdTipoImovel, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdTipoImovel)
                .Index(t => t.IdPacote);
            
            CreateTable(
                "dbo.TiposImoveis",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NomeDoTipo = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.PedidoAdicional",
                c => new
                    {
                        IdPedido = c.Int(nullable: false),
                        IdAdicional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPedido, t.IdAdicional })
                .ForeignKey("dbo.Pedidos", t => t.IdPedido, cascadeDelete: true)
                .ForeignKey("dbo.Adicionais", t => t.IdAdicional, cascadeDelete: true)
                .Index(t => t.IdPedido)
                .Index(t => t.IdAdicional);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        IdUsuario = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Pedidos", "IdTipoImovel", "dbo.TiposImoveis");
            DropForeignKey("dbo.Pedidos", "IdPacote", "dbo.Pacotes");
            DropForeignKey("dbo.Pedidos", "IdCliente", "dbo.Clientes");
            DropForeignKey("dbo.PedidoAdicional", "IdAdicional", "dbo.Adicionais");
            DropForeignKey("dbo.PedidoAdicional", "IdPedido", "dbo.Pedidos");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuario" });
            DropIndex("dbo.PedidoAdicional", new[] { "IdAdicional" });
            DropIndex("dbo.PedidoAdicional", new[] { "IdPedido" });
            DropIndex("dbo.Pedidos", new[] { "IdPacote" });
            DropIndex("dbo.Pedidos", new[] { "IdTipoImovel" });
            DropIndex("dbo.Pedidos", new[] { "IdCliente" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.PedidoAdicional");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.TiposImoveis");
            DropTable("dbo.Pedidos");
            DropTable("dbo.Pacotes");
            DropTable("dbo.Clientes");
            DropTable("dbo.Adicionais");
        }
    }
}
