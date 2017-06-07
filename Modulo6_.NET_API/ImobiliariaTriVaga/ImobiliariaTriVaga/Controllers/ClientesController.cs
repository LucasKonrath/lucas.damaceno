using ImobiliariaTriVaga.Infraestrutura;
using ImobiliariaTriVaga.Infraestrutura.Entidades;
using ImobiliariaTriVaga.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;

namespace ImobiliariaTriVaga.Controllers
{
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    [RoutePrefix("api/Cliente")]
    public class ClientesController : ApiController
    {
        private Contexto contexto = new Contexto();

        private ClienteRepositorio repositorio = new ClienteRepositorio();


        [Route("CPF")]
        [HttpGet]
        public HttpResponseMessage ObterClientePorEmail(string CPF)
        {
            var cliente = repositorio.Obter(CPF);
            if (cliente == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Cliente com o CPF informado não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = cliente });
        }


        [Route("criar")]
        [HttpPost]
        public HttpResponseMessage CriarCliente(Cliente cliente)
        {
            var clienteCriado = repositorio.Criar(cliente);
            if (clienteCriado == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Cliente com CPF informado ja cadastrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = clienteCriado });
        }


    }
}
