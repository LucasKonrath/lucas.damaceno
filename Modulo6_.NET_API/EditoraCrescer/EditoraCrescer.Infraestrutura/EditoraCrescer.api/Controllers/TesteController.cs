using EditoraCrescer.api.App_Start;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.api.Controllers
{
    [MeuAtributoAutorizacao(Roles = "Publicador")]
    public class TesteController : ApiController
    {

        public HttpResponseMessage Get()
        {
            return Request.CreateResponse(HttpStatusCode.OK);

        }

    }
}
