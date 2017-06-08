namespace ImobiliariaTriVaga.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CorrigindoMapeamento : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.PedidoAdicional", "IdPedido", "dbo.Pedidos");
            DropForeignKey("dbo.PedidoAdicional", "IdAdicional", "dbo.PedidosAdicionais");
            DropIndex("dbo.PedidoAdicional", new[] { "IdPedido" });
            DropIndex("dbo.PedidoAdicional", new[] { "IdAdicional" });
            DropTable("dbo.PedidoAdicional");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.PedidoAdicional",
                c => new
                    {
                        IdPedido = c.Int(nullable: false),
                        IdAdicional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPedido, t.IdAdicional });
            
            CreateIndex("dbo.PedidoAdicional", "IdAdicional");
            CreateIndex("dbo.PedidoAdicional", "IdPedido");
            AddForeignKey("dbo.PedidoAdicional", "IdAdicional", "dbo.PedidosAdicionais", "Id", cascadeDelete: true);
            AddForeignKey("dbo.PedidoAdicional", "IdPedido", "dbo.Pedidos", "Id", cascadeDelete: true);
        }
    }
}
