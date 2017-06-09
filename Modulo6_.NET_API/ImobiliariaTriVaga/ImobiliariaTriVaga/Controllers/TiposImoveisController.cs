using ImobiliariaTriVaga.Infraestrutura;
using ImobiliariaTriVaga.Infraestrutura.Repositorios;
using ImobiliariaTriVaga.WebApi;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;

namespace ImobiliariaTriVaga.Controllers
{
    [BasicAuthorization]
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    [RoutePrefix("api/tipoImovel")]

    public class TiposImoveisController : ApiController
    {
        private Contexto contexto = new Contexto();

        private EstoqueImovelRepositorio repositorio = new EstoqueImovelRepositorio();

        [Route("obterPorId/{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterTipoImovelPorID(int id)
        {
            var tipoImovel = repositorio.ObterTipoDeImovelPorId(id);
            if (tipoImovel == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Tipo de imovel com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = tipoImovel });
        }

        [Route("obterImoveis")]
        [HttpGet]
        public HttpResponseMessage ObterImoveis()
        {
            var tiposImoveis = repositorio.ObterTiposDeImoveis();
            if (tiposImoveis == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Tipo de imovel com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = tiposImoveis });
        }


        [Route("obterTamanho/{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterTamanhoPorId(int id)
        {
            var tamanhoImovel = repositorio.ObterTamanhoPorId(id);
            if (tamanhoImovel == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Tipo de imovel com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = tamanhoImovel });
        }

        [Route("obterTamanhosDoImovel/{id:int}")]
        [HttpGet]   
        public HttpResponseMessage ObterTamanhosDoImovel(int id)
        {
            var tamanhosImovel = repositorio.ObterTamanhos(id);
            if (tamanhosImovel == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Tipo de imovel com a ID informada não foi encontrado." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = tamanhosImovel });
        }





    }
}
