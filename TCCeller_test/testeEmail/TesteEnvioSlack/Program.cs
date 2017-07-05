using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace TesteEnvioSlack
{
    class Program
    {
        static void Main(string[] args)
        {

            WebRequest request = WebRequest.Create("https://slack.com/api/chat.postMessage?token=xoxp-166684486960-167730704512-207888517604-333d604d7b051b2c7138d140e39ea825&channel=G634US12L&text=tem%20que%20ser%20bem%20duro&pretty=1");
            WebResponse response = request.GetResponse();
            Console.WriteLine(response);
            response.Close();
        }
    }
}
