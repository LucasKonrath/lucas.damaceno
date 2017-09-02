using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace TesteEnvioSlack
{
    class Program
    {
        static void Main(string[] args)
        {
           
            String diandra = "@diandrarocha";
            Console.WriteLine(System.Uri.EscapeDataString(diandra));
            MandarMensagemNoSlack("@lucasdamaceno", "Teste lucas damazedo");
            MandarMensagemNoSlack("G634US12L", "Teste TCCeller pelo C# com url Encoding");
           
            Console.ReadKey();
        }


        public static void MandarMensagemNoSlack(String usuario, String texto) {


            StringBuilder enviar = new StringBuilder();
            enviar.Append("https://slack.com/api/chat.postMessage?token=xoxp-166684486960-167730704512-208937011574-fb13310c0cd2e90dfe7be45efb0fae8b&channel=");
            enviar.Append(System.Uri.EscapeDataString(usuario));
            enviar.Append("&text=");
            enviar.Append(System.Uri.EscapeDataString(texto));
            enviar.Append("&pretty=1");
            String strenviar = enviar.ToString();
            WebRequest request = WebRequest.Create(strenviar);
             WebResponse response = request.GetResponse();
             Console.WriteLine(response);
             response.Close();

        }
    }
}
