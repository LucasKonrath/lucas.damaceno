using System;

using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemonstrativoSalarial
{
    public class Demonstrativo
    {
        public Demonstrativo(
            double salarioBase,
            double hrsConvencao,
            HorasCalculadas horasExtras,
            HorasCalculadas horasDescontadas,
            double totalProventos,
            Desconto inss,
            Desconto irrf,
            double totalDescontos,
            double totalLiquido,
            Desconto fgts)
        {
            SalarioBase = salarioBase;
            HrsConvencao = hrsConvencao;
            HorasExtras = horasExtras;
            HorasDescontadas = horasDescontadas;
            TotalProventos = totalProventos;
            Inss = inss;
            Irrf = irrf;
            TotalDescontos = totalDescontos;
            TotalLiquido = totalLiquido ;
            Fgts = fgts;
        }

        public string ValorComoString(double value, int decimalPlaces)
        {
            return value.ToString($"F{decimalPlaces}");
        }

        public void imprimirDemo()
        {
       
            Console.WriteLine($"Salário base:{ValorComoString(SalarioBase,2)}");
            Console.WriteLine($"Horas Extras: {ValorComoString(HorasExtras.calcular(),2)}");
            Console.WriteLine($"Horas Descontadas: {ValorComoString(HorasDescontadas.calcular(),2)}");
            Console.WriteLine($"Total Proventos: {ValorComoString(TotalProventos,2)}");
            Console.WriteLine($"Desconto INSS: {ValorComoString(Inss.calcular(),2)}");
            Console.WriteLine($"Desconto IRRF: {ValorComoString(Irrf.calcular(),2)}");
            Console.WriteLine($"Total de Descontos: {ValorComoString(TotalDescontos,2)}");
            Console.WriteLine($"Total Líquido: {ValorComoString(TotalLiquido,2)}");
            Console.WriteLine($"Total FGTS: {ValorComoString(Fgts.calcular(),2)}");

        }

        public double SalarioBase { get; private set; }
        public double HrsConvencao { get; private set; }
        public HorasCalculadas HorasExtras { get; private set; }
        public HorasCalculadas HorasDescontadas { get; private set; }
        public double TotalProventos { get; private set; }
        public Desconto Inss { get; private set; }
        public Desconto Irrf { get; private set; }
        public double TotalDescontos { get; private set; }
        public double TotalLiquido { get; private set; }
        public Desconto Fgts { get; private set; }

    }
}
