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
    [RoutePrefix("api/usuario")]
    public class UsuarioController : ApiController
    {
        private Contexto contexto = new Contexto();

        private UsuarioRepositorio repositorio = new UsuarioRepositorio();

        [HttpGet]
        public HttpResponseMessage ObterUsuarios()
        {
            var usuarios = repositorio.Obter();

            return Request.CreateResponse(HttpStatusCode.OK, new { data = usuarios });

        }

        [Route("{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterUsuarioPorId(int id)
        {
            var usuario = repositorio.ObterUsuarioPorId(id);
            if (usuario == null)
                return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Usuario com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = usuario });
        }

        

        

        


        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
