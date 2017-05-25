using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemonstrativoSalarial
{
    public class Desconto
    {
        public Desconto(double aliquota, double valor)
        {
            Aliquota = aliquota;
            Valor = valor;
        }
        public double calcular()
        {

            return Valor * (Aliquota / 100);

        }
        public double descontoInss;
        public double descontoIrrf;
        public double descontoFgts;
        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }

}
