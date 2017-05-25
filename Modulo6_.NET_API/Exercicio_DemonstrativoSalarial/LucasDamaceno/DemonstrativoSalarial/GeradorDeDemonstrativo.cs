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
        public HorasCalculadas CalcularHorasExtras(double horasextras, double salariobase, double horascat) {

            return new HorasCalculadas(horasextras, salariobase / horascat);

        }

        public HorasCalculadas CalcularHorasDescontadas(double horasdescontadas, double salariobase, double horascat) {

            return new HorasCalculadas(horasdescontadas, salariobase / horascat);
        }

        public double CalcularTotalProventos(double salario, HorasCalculadas hextas, HorasCalculadas hdescontadas) {

            return salario + hextas.calcular() - hdescontadas.calcular();

        }

        public Desconto CalcularInss(double proventos)
        {
            double aliquota;
            if (proventos <= 1000) aliquota = 8.0;
            else if (proventos <= 1500) aliquota = 9.0;
            else aliquota = 10.0;
            return new Desconto(aliquota, proventos);
        }

        public Desconto CalcularIRRF(double proventos, Desconto doInss)
        {
            double aliquota;
            double faixaIRRF = proventos - doInss.calcular();
            if (faixaIRRF < 1710.18) aliquota = 0;
            else if (faixaIRRF < 2563.91) aliquota = 7.5;
            else if (faixaIRRF < 3418.59) aliquota = 15.0;
            else if (faixaIRRF < 4271.59) aliquota = 22.5;
            else aliquota = 27.5;
            return new Desconto(aliquota, faixaIRRF);

        }

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase,
        double horasExtras, double horasDescontadas)
        {

            double SalarioBase = salarioBase;
            double HrsConvencao = horasCategoria;
            HorasCalculadas HorasExtras = CalcularHorasExtras(horasExtras, salarioBase, horasCategoria);
            HorasCalculadas HorasDescontadas = CalcularHorasDescontadas(horasDescontadas, salarioBase, horasCategoria);
            double totalProventos = CalcularTotalProventos(salarioBase, HorasExtras, HorasDescontadas);
            Desconto inss = CalcularInss(totalProventos);
            Desconto irrf = CalcularIRRF(totalProventos, inss);
            double totalDescontos = inss.calcular() + irrf.calcular();
            double totalLiquido = totalProventos - totalDescontos;
            Desconto fgts = new Desconto(11, totalProventos);
            Demonstrativo aRetornar = new Demonstrativo(SalarioBase, HrsConvencao, HorasExtras, HorasDescontadas,
            totalProventos, inss, irrf, totalDescontos, totalLiquido, fgts);
            return aRetornar;
        }
    }
}
