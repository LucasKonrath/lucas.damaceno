using EditoraCrescer.Infraestrutura.Entidades;
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

        public bool UsuarioValido(int id)
        {
            return contexto.Usuarios.Where(x => x.Id == id).Count() > 0;
        }

      

        public List<Usuario> Obter()
        {
            return contexto.Usuarios.ToList();
        }
            
        public Usuario ObterUsuarioPorId(int id)
        {
            return contexto.Usuarios.Where(usuario => usuario.Id == id).FirstOrDefault();
        }



        public void Dispose()
        {
            contexto.Dispose();

        }

    }
}
