using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Demo1.WebApi.Controllers
{
    public class PedidosController : ApiController
    {

        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();

        public IHttpActionResult Post(Pedido pedido)
        {

            var mensagens = new List<string>();
            //if (!produto.Validar(out mensagens)) return BadRequest(string.Join("", mensagens.ToArray()));

            _pedidoRepositorio.Criar(pedido);

            return Ok(pedido);

        }


        public IHttpActionResult Get()
        {
            var pedidos = _pedidoRepositorio.Listar();
            return Ok(pedidos);

        }


        public IHttpActionResult Get(int id)
        {
            var pedido = _pedidoRepositorio.Obter(id);
            return Ok(pedido);

        }

        public IHttpActionResult Delete(int id)
        {
            _pedidoRepositorio.Excluir(id);
            return Ok();

        }

    }
}
