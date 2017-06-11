using ImobiliariaTriVaga.Infraestrutura;
using ImobiliariaTriVaga.Infraestrutura.Entidades;
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

    [EnableCors(origins: "*", headers: "*", methods: "*")]
    [RoutePrefix("api/Pedidos")]
    public class PedidosController : ApiController
    {

        private Contexto contexto = new Contexto();

        private PedidoRepositorio repositorio = new PedidoRepositorio();

        private AdicionalRepositorio adicionalRepositorio = new AdicionalRepositorio();

        //public PedidosController()
        //{
        //    var contexto = new Contexto();
        //    repositorio = new PedidoRepositorio(contexto);
        //    adicionalRepositorio = new AdicionalRepositorio(contexto);
        //}
        [BasicAuthorization]
        [Route("obter/{id:int}")]
        [HttpGet]
        public HttpResponseMessage ObterPedido(int id)
        {
            var pedido = repositorio.Obter(id);
            if (pedido == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Erro no cadastro." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = pedido });
        }

      
        [Route("obtertodos")]
        [HttpGet]
        public HttpResponseMessage ObterTodosPedidos()
        {
            var pedido = repositorio.ObterTodosPedidos();
            if (pedido == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Erro no cadastro." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = pedido });
        }
        [BasicAuthorization]
        [Route("deletar/{id:int}")]
        [HttpDelete]
        public HttpResponseMessage DeletarPedido(int id)
        {
            repositorio.Deletar(id);
            return Request.CreateResponse(HttpStatusCode.OK);
        }
        [BasicAuthorization]
        [Route("retornar/{id:int}")]
        [HttpDelete]
        public HttpResponseMessage RetornarPedido(int id)
        {
            var pedido = repositorio.Retornar(id);
            return Request.CreateResponse(HttpStatusCode.OK, new { data = pedido});
        }

        [HttpGet, BasicAuthorization(Roles = "GERENTE")]
        [Route("checarGerente")]
        public HttpResponseMessage Get()
        {
            return Request.CreateResponse(HttpStatusCode.OK);
        }

        [BasicAuthorization]
        [Route("criar")]
        [HttpPost]
        public HttpResponseMessage CriarPedido(Pedido pedido)
        {
            
            var pedidoCriado = repositorio.Criar(pedido, contexto);
            List<int> adicionaisDoPedido = new List<int>();
            List<int> quantidadeDoAdicional = new List<int>();
            foreach( var adicional in pedidoCriado.Adicionais)
            {
                adicionaisDoPedido.Add(adicional.IdAdicional);
                quantidadeDoAdicional.Add(adicional.Quantidade);
                adicionalRepositorio.removerDoEstoque(adicional.IdAdicional, adicional.Quantidade, contexto);
            }
            pedidoCriado.IdPacote = pedido.IdPacote;
            pedidoCriado.IdTipoImovel = pedido.IdTipoImovel;
            contexto.SaveChanges();
            if (pedidoCriado == null) return Request.CreateResponse(HttpStatusCode.NotFound, new { mensagens = new string[] { "Erro no cadastro." } });
            return Request.CreateResponse(HttpStatusCode.OK, new { data = new { id = pedidoCriado.Id, IdCliente = pedidoCriado.IdCliente, IdTipoImovel = pedidoCriado.IdTipoImovel,
                DataPrevista = pedidoCriado.DataEntregaPrevista, adicionais = new { adicionais = adicionaisDoPedido, quantidadeDoAdicional = quantidadeDoAdicional }  } });
        }

    }
}
