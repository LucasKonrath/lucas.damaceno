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
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private RevisorRepositorio repositorio = new RevisorRepositorio();
            

        [HttpGet]
        public HttpResponseMessage Get()
        {
            var revisores = repositorio.Obter();
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisores });
    
        }

        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterPorId( int id)
        {
            var revisor = repositorio.Obter(id);
            if (revisor == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { error = "Revisor com a ID informada não foi encontrado." });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }


        [HttpPost]
        public HttpResponseMessage Post(Revisor revisor)
        {   
            repositorio.Criar(revisor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }

        [Route("{id:int}")]
        [HttpPut]
        public HttpResponseMessage AlterarRevisor(int id, Revisor revisor)
        {

            repositorio.Modificar(id, revisor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }


        [Route("{id:int}")]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
