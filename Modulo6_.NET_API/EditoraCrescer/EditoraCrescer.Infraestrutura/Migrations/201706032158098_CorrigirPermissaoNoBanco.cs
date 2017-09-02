namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CorrigirPermissaoNoBanco : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Usuarios", newName: "Usuario");
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
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
            
            AddColumn("dbo.Usuario", "Nome", c => c.String());
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuario", "dbo.Usuario");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuario" });
            DropColumn("dbo.Usuario", "Nome");
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Permissao");
            RenameTable(name: "dbo.Usuario", newName: "Usuarios");
        }
    }
}
