namespace ImobiliariaTriVaga.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class dataVendaNaoObrigatoria : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Pedidos", "DataVenda", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Pedidos", "DataVenda", c => c.DateTime(nullable: false));
        }
    }
}
