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
    [RoutePrefix("api/Pacotes")]
    public class PacotesController : ApiController
    {
        private Contexto contexto = new Contexto();

        private EstoqueImovelRepositorio repositorio = new EstoqueImovelRepositorio();


        [Route("IdTipoImovel/{idImovel:int}/IdPacote/{idPacote:int}")]
        [HttpGet]
        public HttpResponseMessage ObterEstoquePorIdsPorID(int idImovel, int idPacote)
        {
            var estoque = repositorio.ObterEstoquePorId(idImovel, idPacote);
            if (estoque == 0) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Estoque do item está zerado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = estoque });
        }

        [Route("obter")]
        [HttpGet]
        public HttpResponseMessage ObterEstoques()
        {
            var adicionais = repositorio.ObterEstoques();
            if (adicionais == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Adicional com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = adicionais });
        }

    }
}
