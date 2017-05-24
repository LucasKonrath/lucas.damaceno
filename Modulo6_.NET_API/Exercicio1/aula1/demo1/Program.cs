using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace demo1
{
    class Program
    {
        static void Main(string[] args)
        {

            var qtdElementos = 0;
            List<int> entradas = new List<int>();
           
            while (true)
            {
                
                Console.WriteLine("Digite um valor");
                var entrada = Console.ReadLine();
                if (entrada == "exit") {
                    int numEntrada = 0;
                    foreach(var entradaIndividual in entradas)
                    {
                        numEntrada++;
                        Console.WriteLine($"Entrada Número {numEntrada} = {entradaIndividual}");
                        
                    }

                    Console.WriteLine("########################FINO");
                    Console.ReadKey();
                    return;

                }
                else
                {
                    var numeroEntrada = 0;
                    bool result = Int32.TryParse(entrada, out numeroEntrada);
                    if (result)
                    {

                        entradas.Add(int.Parse(entrada));

                    }
                    else
                    {
                        Console.WriteLine("Conversão falhou.");
                    }
                    
                }
            }

        }
    }
}
