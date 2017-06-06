using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();


        public PedidoRepositorio()
        {

        }

        public void Dispose()
        {
            contexto.Dispose();

        }
    }
}