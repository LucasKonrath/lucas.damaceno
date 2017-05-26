using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {

       static  List<Heroi> herois = new List<Heroi>()
        {

            new Heroi() {Id = 1, Nome = "Vegeta", poder = new Poder() { Nome = "Genki Dama", Dano = 9001} },
            new Heroi() {Id = 2, Nome = "Homem de ferro", poder = new Poder() { Nome = "Dinheiro", Dano = 9000} },
            new Heroi() {Id = 3, Nome = "Super Choque", poder = new Poder() { Nome = "220V", Dano = 9000} },
            new Heroi() {Id = 4, Nome = "Minha mãe", poder = new Poder() { Nome = "Chinelada", Dano = 9000} },
            new Heroi() {Id = 5, Nome = "Xablau", poder = new Poder() { Nome = "Ladroagem", Dano = 9000} },



        };
        static int IDRef = 6;

        public IEnumerable<Heroi> Get( int? id = null)
        {
         
            if (id == null) return herois;
            return herois.Where(heroi =>  heroi.Id == id);

        }

        public IHttpActionResult Post(Heroi heroi)
        {
            if (heroi.Id >= IDRef) 
            {
                heroi.Id = IDRef;
                herois.Add(heroi);
                IDRef++;
                return Ok();
            }
            else
                return BadRequest();

        }

    }
}
