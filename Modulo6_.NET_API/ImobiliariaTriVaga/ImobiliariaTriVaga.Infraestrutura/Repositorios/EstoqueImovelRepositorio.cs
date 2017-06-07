using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Repositorios
{
    public class EstoqueImovelRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();


        public EstoqueImovelRepositorio()
        {

        }

        public void Dispose()
        {
            contexto.Dispose();

        }
    }
}