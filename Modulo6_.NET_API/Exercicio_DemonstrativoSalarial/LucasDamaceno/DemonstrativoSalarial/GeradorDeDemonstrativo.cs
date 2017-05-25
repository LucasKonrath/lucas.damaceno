using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemonstrativoSalarial
{
    public class GeradorDeDemonstrativo : IFolhaPagamento
    {

        public GeradorDeDemonstrativo()
        {

        }

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase,
        double horasExtras, double horasDescontadas)
        {

            double SalarioBase = salarioBase;
            double HrsConvencao = horasCategoria;
            HorasCalculadas HorasExtras = new HorasCalculadas(horasExtras, salarioBase / horasCategoria);
            HorasCalculadas HorasDescontadas = new HorasCalculadas(horasDescontadas, salarioBase / horasCategoria);
            double totalProventos = (salarioBase + HorasExtras.calcular() - HorasDescontadas.calcular());
            double aliquota;
            if (totalProventos < 1000) aliquota = 8.0;
            else if (totalProventos < 1500) aliquota = 9.0;
            else aliquota = 10.0;
            Desconto inss = new Desconto(aliquota, totalProventos);
            double faixaIRRF = totalProventos - inss.calcular();
            if (faixaIRRF < 1710.18) aliquota = 0;
            else if (faixaIRRF < 2563.91) aliquota = 7.5;
            else if (faixaIRRF < 3418.59) aliquota = 15.0;
            else if (faixaIRRF < 4271.59) aliquota = 22.5;
            else aliquota = 27.5;
            Desconto irrf = new Desconto(aliquota, faixaIRRF);
            double totalDescontos = inss.calcular() + irrf.calcular();
            double totalLiquido = totalProventos - totalDescontos;
            Desconto fgts = new Desconto(11, totalProventos);
            Demonstrativo aRetornar = new Demonstrativo(SalarioBase, HrsConvencao, HorasExtras, HorasDescontadas,
            totalProventos, inss, irrf, totalDescontos, totalLiquido, fgts);
            return aRetornar;
        }
    }
}
