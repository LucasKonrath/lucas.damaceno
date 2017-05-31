using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {

        private Contexto contexto;

        public LivroRepositorio()
        {

            contexto = new Contexto();

        }

        public List<object> Obter()
        {
            return contexto.Livros.Select( x=> new { Isbn = x.Isbn, Titulo = x.Titulo, Capa = x.Capa, NomeAutor = x.Autor.Nome, Genero = x.Genero  }).ToList<object>();
        }

        public List<Livro> ObterPorGenero(string genero)
        {
            return contexto.Livros.
                Where(x => x.Genero.ToLower() 
                == genero.ToLower()).ToList();
        }

        public void Criar(Livro livro)
        {

            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public void Modificar(int isbn, Livro livro)
        {

            Livro livroOriginal = contexto.Livros.Where(x => x.Isbn == isbn).FirstOrDefault();
            contexto.Entry(livroOriginal).CurrentValues.SetValues(livro);
            contexto.SaveChanges();
        }


        public void Deletar(int id)
        {
            Livro livroRemover = contexto.Livros.FirstOrDefault(x => x.Isbn == id);
            contexto.Livros.Remove(livroRemover);
            contexto.SaveChanges();

        }

        public Livro Obter(int id)
        {
            Livro livroObtido = contexto.Livros.FirstOrDefault(x => x.Isbn == id);
            return livroObtido;
        }

        public void Dispose()
        {
            contexto.Dispose();

        }

       
    }
}
                