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
    [RoutePrefix("api/Usuario")]
    public class UsuarioController : ApiController
    {
        private Contexto contexto = new Contexto();

        private UsuarioRepositorio repositorio = new UsuarioRepositorio();


        [HttpGet]
        public HttpResponseMessage ObterUsuarios()
        {
            var usuarios = repositorio.Listar();
            return Request.CreateResponse(HttpStatusCode.OK, new { data = usuarios });

        }


        [HttpGet]
        public HttpResponseMessage ObterUsuarioPorEmail(string email)
        {
            var usuarios = repositorio.Obter(email);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = usuarios });

        }









        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}
