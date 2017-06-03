namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarUsuarios : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            AlterColumn("dbo.Livros", "DataPublicacao", c => c.DateTime());
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            AlterColumn("dbo.Livros", "DataPublicacao", c => c.DateTime(nullable: false));
            DropTable("dbo.Usuarios");
        }
    }
}
