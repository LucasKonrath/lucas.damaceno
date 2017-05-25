using System;
namespace Crescer.Exercicio3
{
    public interface IFolhaPagamento
    {
        Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas);
    }
    public class Test{
        
        public static void Main()
    {
        GeradorDeDemonstrativo gerar = new GeradorDeDemonstrativo();
        Demonstrativo demo = gerar.GerarDemonstrativo(200,5000,50,10);
        demo.imprimirDemo();
    }
        
    }

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
        
        public void imprimirDemo(){
            
            Console.WriteLine(SalarioBase);
            Console.WriteLine(HorasExtras.calcular());
            Console.WriteLine(HorasDescontadas.calcular());
            Console.WriteLine(TotalProventos);
            Console.WriteLine(Inss.calcular());
            Console.WriteLine(Irrf.calcular());
            Console.WriteLine(TotalDescontos);
            Console.WriteLine(TotalLiquido);
            Console.WriteLine(Fgts.calcular());
            
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
    
    public class HorasCalculadas
    {
        public HorasCalculadas(double qtdHoras, double valorTotalHoras)
        {
            QtdHoras = qtdHoras;
            ValorTotalHoras = valorTotalHoras;
        }
        public double calcular(){
            
            double valorARetornar = QtdHoras * ValorTotalHoras;
            return valorARetornar;
            
        }
        public double QtdHoras { get; private set; }
        public double ValorTotalHoras { get; private set; }
    }
    
    public class Desconto
    {
        public Desconto(double aliquota, double valor)
        {
            Aliquota = aliquota;
            Valor = valor;
        }
        public double calcular(){
            
            return Valor*(Aliquota/100);
            
        }
        public double descontoInss;
        public double descontoIrrf;
        public double descontoFgts;
        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }
    
    public class GeradorDeDemonstrativo : IFolhaPagamento{
        
        public GeradorDeDemonstrativo()
        {
            
        }
        
        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, 
        double horasExtras, double horasDescontadas){
                
            double SalarioBase = salarioBase;
            double HrsConvencao = horasCategoria;
            HorasCalculadas HorasExtras = new HorasCalculadas(horasExtras, salarioBase/horasCategoria);
            HorasCalculadas HorasDescontadas = new HorasCalculadas(horasDescontadas, salarioBase/horasCategoria);
            double totalProventos = (salarioBase + HorasExtras.calcular() - HorasDescontadas.calcular());
            double aliquota;
            if(totalProventos < 1000) aliquota = 8.0;
            else if (totalProventos < 1500) aliquota = 9.0;
            else aliquota = 10.0;
            Desconto inss = new Desconto(aliquota, totalProventos);
            double faixaIRRF = totalProventos - inss.calcular();
            if(faixaIRRF < 1710.18) aliquota = 0;
            else if(faixaIRRF < 2563.91) aliquota = 7.5;
            else if(faixaIRRF < 3418.59) aliquota = 15.0;
            else if(faixaIRRF < 4271.59) aliquota = 22.5;
            else aliquota = 27.5;
            Desconto irrf = new Desconto(aliquota, faixaIRRF);
            double totalDescontos = inss.calcular() + irrf.calcular();
            double totalLiquido = totalProventos - totalDescontos;
            Desconto fgts = new Desconto(11, totalProventos);
            Demonstrativo aRetornar = new Demonstrativo(SalarioBase, HrsConvencao, HorasExtras, HorasDescontadas,
            totalProventos,inss,irrf,totalDescontos,totalLiquido,fgts);
            return aRetornar;
        }
    }
        
}
