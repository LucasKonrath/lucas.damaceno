using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Demo1.Dominio.Entidades
{
    public class Produto
    {
        public int Id { get; set; }
        public string Nome { get; set; }

        public decimal Preco { get; set; }
        public int  Estoque { get; set; }


        

        public bool Validar(out List<string> mensagens) {

            mensagens = new List<String>();

            if (Estoque < 1) mensagens.Add("Estoque deve ser maior que zero.");
            if (Preco < 0.01M) mensagens.Add("Preço deve ser maior que zero.");
            if (string.IsNullOrWhiteSpace(Nome)) mensagens.Add("Produto deve ter pelo menos uma letra.");
            return mensagens.Count() == 0;


        }

    }
}