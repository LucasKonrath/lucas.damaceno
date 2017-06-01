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
        public HttpResponseMessage ObterLivros()
        {
            var livros = repositorio.Obter();
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livros });
       
        }

        [Route("{isbn:int}")]
        [HttpGet]
        public HttpResponseMessage ObterLivroPorId(int isbn)
        {
            var livro = repositorio.Obter(isbn);

            return Request.CreateResponse(HttpStatusCode.OK, new { data = livro });
        }


        [Route("{genero}")]
        [HttpGet]
        public HttpResponseMessage ObterLivroPorGenero(string genero)
        {
            var livros = repositorio.ObterPorGenero(genero);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livros });
  
        }

        [Route("Lancamentos")]
        [HttpGet]
        public HttpResponseMessage ObterLancamentosDeLivros()
        {
            var dataAtual = DateTime.Today;
            var livros = repositorio.ObterLancamentos(dataAtual);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livros});
          
        }

        [HttpPost]
        public HttpResponseMessage Post(Livro livro)
        {

            repositorio.Criar(livro);

            return Request.CreateResponse(HttpStatusCode.OK, new { data = livro });
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
        public HttpResponseMessage ModificarLivro(int id, Livro livro) {

            repositorio.Modificar(id,livro);

            return Request.CreateResponse(HttpStatusCode.OK, new { data = livro });
        }


        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
