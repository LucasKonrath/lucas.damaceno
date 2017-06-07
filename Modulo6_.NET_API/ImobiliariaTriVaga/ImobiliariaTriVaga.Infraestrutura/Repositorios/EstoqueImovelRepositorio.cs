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

        public TipoImovel ObterTipoDeImovelPorId(int id)
        {
            return contexto.TiposImoveis.Where(imovel => imovel.Id == id).FirstOrDefault();
        }

        public List<TipoImovel> ObterTiposDeImoveis()
        {
            return contexto.TiposImoveis.ToList();
        }

        public int ObterEstoquePorId(int idImovel, int idPacote)
        {
            return contexto
                .EstoqueImovel
                .Where(estoque => estoque.IdPacote == idPacote
                && estoque.IdTipoImovel == idImovel)
                .Select(estoque => estoque.Quantidade).FirstOrDefault();
        }


        public dynamic ObterEstoques()
        {
            return contexto
                .EstoqueImovel
                .Select(estoque => new { estoque = estoque.Quantidade,
                NomeDoImovel = estoque.TipoImovel.NomeDoTipo,
                NomeDoPacote = estoque.Pacote.Nome,

                })
                .ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();

        }

      
    }
}