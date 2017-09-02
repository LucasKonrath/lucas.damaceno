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
            if (revisor == null)
                return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Revisor com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }


        [HttpPost]
        public HttpResponseMessage Post(Revisor revisor)
        {
            if (revisor.Id != 0)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Para cadastrar revisor novo, não informe sua ID." } });
            repositorio.Criar(revisor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }

        [Route("{id:int}")]
        [HttpPut]
        public HttpResponseMessage AlterarRevisor(int id, Revisor revisor)
        {
            if(id != revisor.Id)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "ID informado e do Revisor que deseja modificar diferem." } });
            if(!repositorio.RevisorValido(id))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Revisor que deseja modificar não existe." } });
            repositorio.Modificar(id, revisor);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = revisor });
        }


        [Route("{id:int}")]
        [HttpDelete]
        public HttpResponseMessage Delete(int id)
        {
            if(!repositorio.RevisorValido(id))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Revisor que deseja deletar não existe" } });
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
