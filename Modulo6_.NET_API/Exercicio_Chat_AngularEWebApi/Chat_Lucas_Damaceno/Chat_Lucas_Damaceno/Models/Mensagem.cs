using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Chat_Lucas_Damaceno.Models
{
    public class Mensagem
    {
        public int Id { get; set; }
        public string NomeUsuario { get; set; }

        public string FotoUrlUsuario { get; set; }

        public DateTime DataMensagem { get; set; }
        public string CorpoMensagem { get; set; }
     
    }
}