using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Repositorios
{
    public class AdicionalRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();


        public AdicionalRepositorio()
        {

        }

        public Adicional ObterPorId(int id)
        {
            return contexto.Adicionais.Where(x => x.Id == id).FirstOrDefault();
        }
        public List<Adicional> ObterAdicionais()
        {
            return contexto.Adicionais.ToList();
        }
        public void Dispose()
        {
            contexto.Dispose();

        }

       
    }
}