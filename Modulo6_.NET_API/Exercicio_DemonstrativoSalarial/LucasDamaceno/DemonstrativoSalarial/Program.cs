using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

 namespace DemonstrativoSalarial
{
    class Program
    {
        static void Main(string[] args)
        {
            GeradorDeDemonstrativo gerar = new GeradorDeDemonstrativo();
            Demonstrativo demo = gerar.GerarDemonstrativo(200, 5000, 50, 10);
            demo.imprimirDemo();
            Console.ReadKey();
        }
    }
}
