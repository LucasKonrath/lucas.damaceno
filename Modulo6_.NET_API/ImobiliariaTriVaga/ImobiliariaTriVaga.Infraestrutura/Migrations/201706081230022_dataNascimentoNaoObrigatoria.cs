namespace ImobiliariaTriVaga.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class dataNascimentoNaoObrigatoria : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Clientes", "DataNascimento", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Clientes", "DataNascimento", c => c.DateTime(nullable: false));
        }
    }
}
