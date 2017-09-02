using Chat_Lucas_Damaceno.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.RegularExpressions;
using System.Web.Http;

namespace Chat_Lucas_Damaceno.Controllers
{
    public class ChatController : ApiController
    {

        private static object objetoLock = new object();
        public static List<Mensagem> mensagens = new List<Mensagem>();
        
        private static int contador = 1;
        public IEnumerable<Mensagem> Get()
        { 
            return mensagens.
                OrderBy(mensagem => mensagem.DataMensagem)
                .Where(mensagem => mensagem.Id > contador - 30);
        }

        public IHttpActionResult Post(Mensagem mensagem)
        {
            if (mensagem == null)
            {
                return BadRequest();
            }
            else
            {
                lock (objetoLock) {
                mensagem.DataMensagem = DateTime.Now;
                mensagem.CorpoMensagem = Regex.Replace(mensagem.CorpoMensagem, "nunes", "$$$$$$$$$$$", RegexOptions.IgnoreCase);
                mensagem.Id = contador++;
                mensagens.Add(mensagem);
                }
              

                return Ok(mensagem);
            }
        }


    }
}
