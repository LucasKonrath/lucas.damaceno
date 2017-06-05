using EditoraCrescer.Infraestrutura;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;

namespace EditoraCrescer.api.Controllers
{
    [EnableCors(origins: "*", headers: "*", methods: "*")]
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

        [Route("Completos")]
        [HttpGet]
        public HttpResponseMessage ObterLivrosCompletos()
        {
            var livros = repositorio.ObterLivrosCompletos();

            return Request.CreateResponse(HttpStatusCode.OK, new { data = livros });

        }

        [Route("{isbn:int}")]
        [HttpGet]
        public HttpResponseMessage ObterLivroPorId(int isbn)
        {
            var livro = repositorio.Obter(isbn);
            if (livro == null)
                return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Livro com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livro });
        }

        [Route("{pular:int}/{pegar:int}")]
        [HttpGet]
        public HttpResponseMessage ObterLivrosComSkipETake(int pular, int pegar)
        {
            var livros = repositorio.ObterComParametros(pular, pegar);
            if (livros == null)
                return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Livro com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livros });
        }


        [Route("{genero}")]
        [HttpGet]
        public HttpResponseMessage ObterLivroPorGenero(string genero)
        {
            var livros = repositorio.ObterPorGenero(genero);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livros});
         

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
            if(livro.Isbn != 0)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Por favor não informe a ID de um livro que deseja criar, isso será feito automaticamente." } });
            repositorio.Criar(livro);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livro });
        }

        [Route("{id:int}")]
        [HttpDelete]
        public HttpResponseMessage Delete(int id)
        {
            if(!repositorio.LivroValido(id))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Livro que deseja deletar não está cadastrado." } });
            repositorio.Deletar(id);
            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [Route("{id:int}")]
        [HttpPut]
        public HttpResponseMessage ModificarLivro(int id, Livro livro) {



            if(id != livro.Isbn)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Isbns do Livro e do caminho não conferem." } });
            if(!repositorio.LivroValido(id))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Livro de Isbn especificado não existe." } });
            repositorio.Modificar(id,livro);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = livro });
        }

        [Route("revisar/{isbn:int}")]
        [HttpPut]
        public HttpResponseMessage RevisarLivro(int isbn)
        {
            
           
            if (!repositorio.LivroValido(isbn))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Livro de Isbn especificado não existe." } });
            repositorio.Revisar(isbn);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = "Revisado com sucesso." });

        }


        [Route("publicar/{isbn:int}")]
        [HttpPut]
        public HttpResponseMessage PublicarLivro(int isbn)
        {

            var dataAtual = DateTime.Today.DayOfWeek;
            if(dataAtual == DayOfWeek.Saturday || dataAtual == DayOfWeek.Sunday) return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = "Livros não podem ser publicados no fim de semana." });
            if (!repositorio.LivroValido(isbn))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Livro de Isbn especificado não existe." } });
            var livro = repositorio.Publicar(isbn);
            if(livro.DataPublicacao == null) return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens =  "Livro não revisado não pode ser publicado." });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = "Publicado com sucesso." });

        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
