using EditoraCrescer.Infraestrutura;
using EditoraCrescer.Infraestrutura.Entidades;

using System;

class Program
{
    static void Main(string[] args)
    {
        var autor1 = new Autor() { Nome = "Tolkien" };
        var autor2 = new Autor() { Nome = "Machado de Assis" };
        var revisor1 = new Revisor() { Nome = "Borgo" };
        var revisor2 = new Revisor() { Nome = "Alborghetti" };
        using (var contexto = new Contexto())
        {
            //Inclusão
            contexto.Autores.Add(autor1);
            contexto.Autores.Add(autor2);
            contexto.Revisores.Add(revisor1);
            contexto.Revisores.Add(revisor2);
            contexto.SaveChanges();

            var livro = new Livro()
            {
                Autor = autor1,
                Titulo = "O senhor dos anéis",
                Descricao = "Um livro bem legal",
                Genero = "Aventura",
                DataPublicacao = DateTime.Now,
                Revisor = revisor1,
                DataRevisao = DateTime.Now
            };

            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }
    }
}