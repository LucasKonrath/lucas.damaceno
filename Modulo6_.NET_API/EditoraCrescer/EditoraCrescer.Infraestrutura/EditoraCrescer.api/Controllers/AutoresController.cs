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
{   [EnableCors(origins:"*", headers: "*", methods: "*")]
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private AutorRepositorio repositorio = new AutorRepositorio();
        [HttpGet]
        public HttpResponseMessage ObterAutores()
        {
            var autores = repositorio.Obter();

            return   Request.CreateResponse(HttpStatusCode.OK, new { data = autores});
        }

        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterAutorPorId(int id)
        {
            var autor = repositorio.Obter(id);
            if (autor == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Autor com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = autor });
        }


        [Route("{id:int}/Livros")]
        [HttpGet]
        public HttpResponseMessage ObterLivrosAutores(int id)
        {
            var livros = repositorio.ObterLivrosDoAutor(id);

            return Request.CreateResponse(HttpStatusCode.OK, new { data = livros });
        }

        [HttpPost]

        public HttpResponseMessage Post(Autor autor)
        {
            if(autor.Id != 0)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Para criar um novo autor, não defina o seu ID." } });
            repositorio.Criar(autor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = autor });
        }

        [Route("{id:int}")]
        [HttpPut]
        public HttpResponseMessage Update(int id, Autor autor)
        {
            if(autor.Id != id)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "ID informado e ID do Autor informado não conferem." } });
            if(!repositorio.AutorValido(id))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens =  new string[] { "Autor que você está tentando modificar não existe." } });
            Autor autorNovo = repositorio.Modificar(id, autor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = autorNovo });
        }

        [Route("{id:int}")]
        [HttpDelete]
        public HttpResponseMessage Delete(int id)
        {
            if (!repositorio.AutorValido(id))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Não existe autor com o ID informado." } });
            repositorio.Deletar(id);
            return Request.CreateResponse(HttpStatusCode.OK);

        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
