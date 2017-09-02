using System;

namespace demo1
{
    public class Pessoa
    {
        private double PesoPessoa;
        private double AlturaPessoa;

        public Pessoa(double peso, double altura)
        {
            PesoPessoa = peso;
            AlturaPessoa = altura;
            imprimirIMC();
        }
            




        public void imprimirIMC()
        {
            double resultado = PesoPessoa / Math.Pow(AlturaPessoa, 2);
            Console.WriteLine($"Seu IMC: { resultado}");
        }

        public string Nome { get; set; }
        public int? Id { get; set; }
        public DateTime DataNascimento { get; set; }

    }
}
