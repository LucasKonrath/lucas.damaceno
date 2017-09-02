namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class EditarLivroEAdicionarNotNulls : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "IdAutor", "dbo.Autores");
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "IdAutor" });
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            AlterColumn("dbo.Livros", "IdAutor", c => c.Int());
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int());
            CreateIndex("dbo.Livros", "IdAutor");
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdAutor", "dbo.Autores", "Id");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropForeignKey("dbo.Livros", "IdAutor", "dbo.Autores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            DropIndex("dbo.Livros", new[] { "IdAutor" });
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            AlterColumn("dbo.Livros", "IdAutor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "IdRevisor");
            CreateIndex("dbo.Livros", "IdAutor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Livros", "IdAutor", "dbo.Autores", "Id", cascadeDelete: true);
        }
    }
}
