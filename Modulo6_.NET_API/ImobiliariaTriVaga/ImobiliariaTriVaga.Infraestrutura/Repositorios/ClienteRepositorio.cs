using ImobiliariaTriVaga.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Repositorios
{
    public class ClienteRepositorio : IDisposable
    {

        private Contexto contexto = new Contexto();


        public ClienteRepositorio()
        {

        }

        public Cliente Obter(string CPF)
        {
            return contexto.Clientes.Where(cliente => cliente.Cpf.Equals(CPF)).FirstOrDefault();
        }

        public Cliente Criar(Cliente cliente)
        {
            if (Obter(cliente.Cpf) != null) return null;
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
            return cliente;
        }

        public void Excluir(int id)
        {
            var clienteRemover = ObterPorId(id);
            contexto.Clientes.Remove(clienteRemover);
            contexto.SaveChanges();
        }

        public Cliente ObterPorId(int id)
        {
            return contexto.Clientes.Where(x => x.Id == id).FirstOrDefault();
        }

        public void Dispose()
        {
            contexto.Dispose();

        }

        
    }
}