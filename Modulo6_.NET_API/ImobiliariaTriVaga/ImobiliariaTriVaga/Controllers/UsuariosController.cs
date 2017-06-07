using ImobiliariaTriVaga.Infraestrutura;
using ImobiliariaTriVaga.Infraestrutura.Entidades;
using ImobiliariaTriVaga.Infraestrutura.Repositorios;
using ImobiliariaTriVaga.WebApi;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;
using System.Web.Http.Cors;

namespace ImobiliariaTriVaga.api.Controllers
{
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    [RoutePrefix("api/Usuario")]
    public class UsuarioController : ApiController
    {
        private Contexto contexto = new Contexto();

        private UsuarioRepositorio repositorio = new UsuarioRepositorio();

        [BasicAuthorization]
        [HttpGet]
        public HttpResponseMessage Obter()
        {
            var usuario = repositorio.Obter("gerente@trivaga.com");

            if (usuario == null)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = "Usuario/Email não cadastrados." });
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = new { Nome = usuario.Nome, Permissoes = usuario.Permissoes, Email = usuario.Email } });
        }







        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }

    }
}