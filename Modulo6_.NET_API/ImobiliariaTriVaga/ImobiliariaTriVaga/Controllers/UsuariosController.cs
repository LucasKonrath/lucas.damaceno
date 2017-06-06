using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();


        public UsuarioRepositorio()
        {

        }



        public IEnumerable<Usuario> Listar()
        {
            return contexto.Usuarios.ToList();
        }

        public Usuario ObterPorId(int id)
        {
            return contexto.Usuarios.Where(usuario => usuario.Id == id).FirstOrDefault();
        }

        public Usuario Obter(string email)
        {
            return contexto.
                Usuarios.Include("Permissoes").Where(x => x.Email.Equals(email)).FirstOrDefault();
        }


        public void Dispose()
        {
            contexto.Dispose();

        }
    }
}