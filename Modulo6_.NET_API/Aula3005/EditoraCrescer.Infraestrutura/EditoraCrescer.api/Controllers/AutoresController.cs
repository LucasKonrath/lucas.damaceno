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
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController
    {
        private Contexto contexto = new Contexto();

        private AutorRepositorio repositorio = new AutorRepositorio();
        [HttpGet]
        public IHttpActionResult ObterAutores()
        {
            var autores = repositorio.Obter();

            return Ok(autores);
        }

        [Route("{id:int}")]
        [HttpGet]
        public IHttpActionResult ObterAutoresPorId(int id)
        {
            var autores = repositorio.Obter(id);

            return Ok(autores);
        }


        [Route("{id:int}/Livros")]
        [HttpGet]
        public IHttpActionResult ObterLivrosAutores(int id)
        {
            var livros = repositorio.ObterLivrosDoAutor(id);

            return Ok(livros);
        }

        [HttpPost]

        public IHttpActionResult Post(Autor autor)
        {

            repositorio.Criar(autor);
            return Ok(autor);
        }

        [Route("{id:int}")]
        [HttpPut]
        public IHttpActionResult Update(int id, Autor autor)
        {
            repositorio.Modificar(id, autor);
            return Ok();
        }

        [Route("{id:int}")]
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Deletar(id);
            return Ok();
        }

    }
}
