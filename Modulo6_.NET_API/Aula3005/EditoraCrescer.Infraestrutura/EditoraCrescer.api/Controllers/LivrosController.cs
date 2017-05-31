using EditoraCrescer.Infraestrutura;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.api.Controllers
{
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private Contexto contexto = new Contexto();
        
        private LivroRepositorio repositorio = new LivroRepositorio();

        [HttpGet]
        public IHttpActionResult ObterLivros()
        {
            var livros = repositorio.Obter();
            
            return Ok(livros);
        }

        [Route("{isbn:int}")]
        [HttpGet]
        public IHttpActionResult ObterLivroPorId(int isbn)
        {
            var livro = repositorio.Obter(isbn);

            return Ok(livro);
        }


        [Route("{genero}")]
        [HttpGet]
        public IHttpActionResult ObterLivroPorGenero(string genero)
        {
            var livros = repositorio.ObterPorGenero(genero);

            return Ok(livros);
        }

        [HttpPost]
        public IHttpActionResult Post(Livro livro)
        {

            repositorio.Criar(livro);
       
            return Ok(livro);
        }

        [Route("{id:int}")]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);

            return Ok();
        }

        [Route("{id:int}")]
        [HttpPut]
        public IHttpActionResult ModificarLivro(int id, Livro livro) {

            repositorio.Modificar(id,livro);

          return Ok(livro);
        }


        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
