using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaTriVaga.Infraestrutura.Entidades
{
    public class Cliente
     {
         public int Id { get; set; }
         public string Cpf { get; set; }
        public string Genero { get; set; }
        public string Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public string Email { get; set; }
         public string Endereco { get; set; }
      
     }
}
