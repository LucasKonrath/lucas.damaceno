using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio
    {

        private Contexto contexto = new Contexto();

        public RevisorRepositorio()
        {



        }

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }


        public Revisor Obter(int id)
        {
            return contexto.Revisores.Where(x => x.Id == id).FirstOrDefault();
        }

        public void Criar(Revisor revisor)
        {

            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public void Modificar(int id, Revisor revisorModificado)
        {

            Revisor revisorOriginal = contexto.Revisores.Where(x => x.Id == id).FirstOrDefault();
            revisorModificado.Id = id;
            contexto.Entry(revisorOriginal).CurrentValues.SetValues(revisorModificado);
            contexto.SaveChanges();
        }
        public void Deletar(int id)
        {
            Revisor revisorRemover = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Remove(revisorRemover);
            contexto.SaveChanges();

        }

    }
}
