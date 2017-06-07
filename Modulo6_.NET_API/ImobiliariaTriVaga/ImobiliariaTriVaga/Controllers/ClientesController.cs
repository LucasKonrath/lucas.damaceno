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


        [Route("obterPorId/{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterClientePorID(int id)
        {
            var cliente = repositorio.ObterPorId(id);
            if (cliente == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Cliente com a ID informada não foi encontrado." } });
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


        [Route("deletar/{id:int}")]
        [HttpDelete]
        public HttpResponseMessage Deletar(int id)
        {
            repositorio.Excluir(id);
            return Request.CreateResponse(HttpStatusCode.OK, new { mensagens = "Cliente Excluido com Sucesso." });
        }

    }
}
