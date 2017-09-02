using EditoraCrescer.Infraestrutura;
using EditoraCrescer.Infraestrutura.Entidades;

using System;

class Program
{
    static void Main(string[] args)
    {
        Console.BackgroundColor = ConsoleColor.White;
        Console.ForegroundColor = ConsoleColor.Green;
        Console.Clear();
        var autor1 = new Autor() { Nome = "Stephen King" };
        var autor2 = new Autor() { Nome = "George R.R Martin" };
        var revisor1 = new Revisor() { Nome = "Woody Allen" };
        var revisor2 = new Revisor() { Nome = "Carol do Galo Frito" };
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
                Autor = autor2,
                Titulo = "ADO .Net",
                Descricao = " TERROR INDESCRITIVEL ",
                Genero = "Terror",
                DataPublicacao = DateTime.Now,
                Revisor = revisor2,
                DataRevisao = DateTime.Now
            };

            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }
        Console.ReadLine();
    }
}