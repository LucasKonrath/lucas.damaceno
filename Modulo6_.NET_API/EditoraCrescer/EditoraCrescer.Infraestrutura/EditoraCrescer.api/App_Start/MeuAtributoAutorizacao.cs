using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Http;
using System.Net.Http;
using System.Web.Http.Controllers;
using System.Text;

namespace EditoraCrescer.api.App_Start
{
    public class MeuAtributoAutorizacao : AuthorizeAttribute
    {

        public override void OnAuthorization(HttpActionContext actionContext)
        {
            if (actionContext.Request.Headers.Authorization == null)
            {

                actionContext.Response = actionContext.Request.CreateResponse(HttpStatusCode.Unauthorized);

            }

            else
            {

                string tokenAutenticacao = actionContext.Request.Headers.Authorization.Parameter;

                string decodedTokenAutenticacao = Encoding.
                                        Default.GetString(Convert.FromBase64String(tokenAutenticacao));

                string[] userNameAndPassword = decodedTokenAutenticacao.Split(':');

                string usuario = userNameAndPassword[0];
                string senha = userNameAndPassword[1];
                string permissoes = "Administrador";

                if (!(usuario == "giovani" && senha == "123456"))
                {
                    actionContext.Response =
                      actionContext
                      .Request
                      .CreateResponse(HttpStatusCode.Unauthorized);
                }


                //Validar role

                if (Roles != permissoes)
                {
                    actionContext.Response = actionContext.Request.CreateResponse(HttpStatusCode.BadRequest);
                }

            }





        }



    }
}