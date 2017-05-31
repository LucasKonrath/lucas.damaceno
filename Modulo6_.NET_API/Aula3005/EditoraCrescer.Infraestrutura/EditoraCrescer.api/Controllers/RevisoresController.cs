using EditoraCrescer.Infraestrutura;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.api.Controllers
{
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private RevisorRepositorio repositorio = new RevisorRepositorio();
            

        [HttpGet]
        public IHttpActionResult Get()
        {
            var revisores = repositorio.Obter();

            return Ok(revisores);
        }

        [Route("{id:int}")]
        [HttpGet]
        public IHttpActionResult ObterPorId( int id)
        {
            var revisores = repositorio.Obter(id);

            return Ok(revisores);
        }


        [HttpPost]
        public IHttpActionResult Post(Revisor revisor)
        {   

            repositorio.Criar(revisor);
            return Ok(revisor);
        }

       

        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }

    }
}
