namespace ImobiliariaTriVaga.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class modificarTotalASerPago : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Pedidos", "TotalASerPago", c => c.Decimal(precision: 18, scale: 2));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Pedidos", "TotalASerPago", c => c.Decimal(nullable: false, precision: 18, scale: 2));
        }
    }
}
