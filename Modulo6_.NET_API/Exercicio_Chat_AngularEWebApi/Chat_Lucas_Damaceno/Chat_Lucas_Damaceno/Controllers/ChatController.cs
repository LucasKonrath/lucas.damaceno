using Chat_Lucas_Damaceno.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web.Http;

namespace Chat_Lucas_Damaceno.Controllers
{
    public class ChatController : ApiController
    {
        Mensagem mensagemTeste = new Mensagem { Id = 2, CorpoMensagem = "bATATA", NomeUsuario = "Ronaldonho Gaucho", FotoUrlUsuario = "http://media.onsugar.com/files/ons1/259/2598730/11_2009/d08b87411e75c516_Ronaldinho.xlarge.jpg" };
        public static List<Mensagem> mensagens = new List<Mensagem>();
        
        private static int contador = 1;
        public IEnumerable<Mensagem> Get()
        {
          
            return mensagens;
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {

                    mensagens.Add(mensagem);
                    mensagem.Id = contador++;
              

                return Ok(mensagem);
            }
        }


    }
}
