namespace ImobiliariaTriVaga.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class modificarAdicionais : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.EstoqueImovel",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdTipoImovel = c.Int(nullable: false),
                        IdPacote = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Pacotes", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.TiposImoveis", t => t.IdTipoImovel, cascadeDelete: true)
                .Index(t => t.IdTipoImovel)
                .Index(t => t.IdPacote);
            
            CreateTable(
                "dbo.PedidosAdicionais",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdPedido = c.Int(nullable: false),
                        IdAdicional = c.Int(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Adicionais", t => t.IdAdicional, cascadeDelete: true)
                .ForeignKey("dbo.Pedidos", t => t.IdPedido, cascadeDelete: true)
                .Index(t => t.IdPedido)
                .Index(t => t.IdAdicional);
            
            AddColumn("dbo.Adicionais", "Estoque", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.PedidosAdicionais", "IdPedido", "dbo.Pedidos");
            DropForeignKey("dbo.PedidosAdicionais", "IdAdicional", "dbo.Adicionais");
            DropForeignKey("dbo.EstoqueImovel", "IdTipoImovel", "dbo.TiposImoveis");
            DropForeignKey("dbo.EstoqueImovel", "IdPacote", "dbo.Pacotes");
            DropIndex("dbo.PedidosAdicionais", new[] { "IdAdicional" });
            DropIndex("dbo.PedidosAdicionais", new[] { "IdPedido" });
            DropIndex("dbo.EstoqueImovel", new[] { "IdPacote" });
            DropIndex("dbo.EstoqueImovel", new[] { "IdTipoImovel" });
            DropColumn("dbo.Adicionais", "Estoque");
            DropTable("dbo.PedidosAdicionais");
            DropTable("dbo.EstoqueImovel");
        }
    }
}
