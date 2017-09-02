using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemonstrativoSalarial
{
    public class HorasCalculadas
    {
        public HorasCalculadas(double qtdHoras, double valorTotalHoras)
        {
            QtdHoras = qtdHoras;
            ValorTotalHoras = valorTotalHoras;
        }
        public double calcular()
        {

            double valorARetornar = QtdHoras * ValorTotalHoras;
            return valorARetornar;

        }
        public double QtdHoras { get; private set; }
        public double ValorTotalHoras { get; private set; }
    }
}
