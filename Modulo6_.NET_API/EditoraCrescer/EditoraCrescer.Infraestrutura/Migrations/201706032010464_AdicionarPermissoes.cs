namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarPermissoes : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissoes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Usuario_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Usuarios", t => t.Usuario_Id)
                .Index(t => t.Usuario_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios");
            DropIndex("dbo.Permissoes", new[] { "Usuario_Id" });
            DropTable("dbo.Permissoes");
        }
    }
}
