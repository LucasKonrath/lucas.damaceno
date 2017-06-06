using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class ClienteRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();


        public ClienteRepositorio()
        {

        }

        public void Dispose()
        {
            contexto.Dispose();

        }
    }
}