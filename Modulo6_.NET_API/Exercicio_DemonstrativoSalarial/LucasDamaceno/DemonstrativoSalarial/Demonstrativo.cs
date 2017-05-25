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
            TotalLiquido = totalLiquido;
            Fgts = fgts;
        }

        public void imprimirDemo()
        {

            Console.WriteLine($"Salário base:{ SalarioBase}");
            Console.WriteLine($"Horas Extras: {HorasExtras.calcular()}");
            Console.WriteLine($"Horas Descontadas: {HorasDescontadas.calcular()}");
            Console.WriteLine($"Total Proventos: {TotalProventos}");
            Console.WriteLine($"Desconto INSS: {Inss.calcular()}");
            Console.WriteLine($"Desconto IRRF: {Irrf.calcular()}");
            Console.WriteLine($"Total de Descontos: {TotalDescontos}");
            Console.WriteLine($"Total Líquido: { TotalLiquido}");
            Console.WriteLine($"Total FGTS: {Fgts.calcular()}");

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
