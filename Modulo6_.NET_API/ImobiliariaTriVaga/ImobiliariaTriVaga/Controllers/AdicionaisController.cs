using ImobiliariaTriVaga.Infraestrutura;
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
    [RoutePrefix("api/Adicionais")]
    public class AdicionaisController : ApiController
    {
        private Contexto contexto = new Contexto();

        private AdicionalRepositorio repositorio = new AdicionalRepositorio();


        [Route("obterPorId/{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterAdicionaisPorID(int id)
        {
            var adicional = repositorio.ObterPorId(id);
            if (adicional == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Adicional com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = adicional });
        }


        [HttpGet]
        public HttpResponseMessage ObterAdicionais()
        {
            var adicionais = repositorio.ObterAdicionais();
            if (adicionais == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Adicional com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = adicionais });
        }

    }
}
