namespace ImobiliariaTriVaga.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarPrecoAoImovel : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.TiposImoveis", "Preco", c => c.Decimal(precision: 18, scale: 2));
        }
        
        public override void Down()
        {
            DropColumn("dbo.TiposImoveis", "Preco");
        }
    }
}
