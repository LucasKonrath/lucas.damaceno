using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity;
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

        internal void descontarDoEstoque(int idTipoImovel, int idPacote)
        {
            var descontar = contexto.EstoqueImovel.Where(entrada => entrada.IdPacote == idPacote &&
                                                        entrada.IdTipoImovel == idTipoImovel).FirstOrDefault();
            if(descontar.Quantidade > 0) descontar.Quantidade -= 1;
            else
            {
                throw new Exception("Impossível realizar operação, pois estoque ficaria menor que 0.");
            }
          
        }

      

        public void Dispose()
        {
            contexto.Dispose();

        }

        public Pacote ObterTamanhoPorId(int id)
        {
            return contexto.Pacotes.Where(pacote => pacote.Id == id).FirstOrDefault();

        }

        public dynamic ObterTamanhos(int id)
        {
            return contexto
                .EstoqueImovel
                .Where(estoque => estoque.IdTipoImovel == id && estoque.Quantidade > 0)
                .Select(estoque => new { Pacote = estoque.Pacote,
                    Quantidade = estoque.Quantidade } )
                .ToList();
        }
    }
}