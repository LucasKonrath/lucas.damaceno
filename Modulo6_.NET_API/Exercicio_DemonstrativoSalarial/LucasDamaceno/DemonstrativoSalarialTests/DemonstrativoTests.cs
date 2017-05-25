using Microsoft.VisualStudio.TestTools.UnitTesting;
using DemonstrativoSalarial;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemonstrativoSalarial.Tests
{
    [TestClass()]
    public class DemonstrativoTests
    {
        [TestMethod()]
        public void DemonstrativoTestIndustriaSal5000Hextras50hDesc10()
        {
            GeradorDeDemonstrativo gerar = new GeradorDeDemonstrativo();
            Demonstrativo demo = gerar.GerarDemonstrativo(200, 5000, 50, 10);
            Assert.AreEqual(5000, demo.SalarioBase);
            Assert.AreEqual(1250.0, demo.HorasExtras.calcular(), 0.10);
            Assert.AreEqual(250.0, demo.HorasDescontadas.calcular(), 0.10);
            Assert.AreEqual(6000.0, demo.TotalProventos, 0.10);
            Assert.AreEqual(600, demo.Inss.calcular(),0.10);
            Assert.AreEqual(1485.00, demo.Irrf.calcular(), 0.10);
            Assert.AreEqual(2085.00, demo.TotalDescontos,0.10);
            Assert.AreEqual(3915.00, demo.TotalLiquido, 0.10);
            Assert.AreEqual(660.00, demo.Fgts.calcular(), 0.10);
        }

        [TestMethod()]
        public void DemonstrativoTestIndustriaSal2500Hextras10hDesc40()
        {
            GeradorDeDemonstrativo gerar = new GeradorDeDemonstrativo();
            Demonstrativo demo = gerar.GerarDemonstrativo(200, 2500, 10, 40);
            Assert.AreEqual(2500, demo.SalarioBase);
            Assert.AreEqual(125.00, demo.HorasExtras.calcular(), 0.10);
            Assert.AreEqual(500.00, demo.HorasDescontadas.calcular(), 0.10);
            Assert.AreEqual(2125.00, demo.TotalProventos, 0.10);
            Assert.AreEqual(212.50, demo.Inss.calcular(), 0.10);
            Assert.AreEqual(143.43, demo.Irrf.calcular(), 0.10);
            Assert.AreEqual(355.93, demo.TotalDescontos, 0.10);
            Assert.AreEqual(1769.06, demo.TotalLiquido, 0.10);
            Assert.AreEqual(233.75, demo.Fgts.calcular(), 0.10);
        }

        [TestMethod()]
        public void DemonstrativoTestIndustriaSal1200Hextras0hDesc5()
        {
            GeradorDeDemonstrativo gerar = new GeradorDeDemonstrativo();
            Demonstrativo demo = gerar.GerarDemonstrativo(200, 1200, 0, 5);
            Assert.AreEqual(1200, demo.SalarioBase);
            Assert.AreEqual(0.00, demo.HorasExtras.calcular(), 0.10);
            Assert.AreEqual(30.00, demo.HorasDescontadas.calcular(), 0.10);
            Assert.AreEqual(1170.00, demo.TotalProventos, 0.10);
            Assert.AreEqual(105.30, demo.Inss.calcular(), 0.10);
            Assert.AreEqual(0.00, demo.Irrf.calcular(), 0.10);
            Assert.AreEqual(105.30, demo.TotalDescontos, 0.10);
            Assert.AreEqual(1064.70, demo.TotalLiquido, 0.10);
            Assert.AreEqual(128.70, demo.Fgts.calcular(), 0.10);
        }

        [TestMethod()]
        public void DemonstrativoTestComercioSal25000Hextras90hDesc10()
        {
            GeradorDeDemonstrativo gerar = new GeradorDeDemonstrativo();
            Demonstrativo demo = gerar.GerarDemonstrativo(170, 25000, 90, 10);
            Assert.AreEqual(25000, demo.SalarioBase);
            Assert.AreEqual(13235.294, demo.HorasExtras.calcular(), 0.10);
            Assert.AreEqual(1470.58, demo.HorasDescontadas.calcular(), 0.10);
            Assert.AreEqual(36764.71, demo.TotalProventos, 0.10);
            Assert.AreEqual(3676.47, demo.Inss.calcular(), 0.10);
            Assert.AreEqual(9099.265, demo.Irrf.calcular(), 0.10);
            Assert.AreEqual(12775.735, demo.TotalDescontos, 0.10);
            Assert.AreEqual(23988.97, demo.TotalLiquido, 0.10);
            Assert.AreEqual(4044.11, demo.Fgts.calcular(), 0.10);
        }

        [TestMethod()]
        public void DemonstrativoComercioSal8000Hextras0hDesc0()
        {
            GeradorDeDemonstrativo gerar = new GeradorDeDemonstrativo();
            Demonstrativo demo = gerar.GerarDemonstrativo(170, 8000, 0, 0);
            Assert.AreEqual(8000, demo.SalarioBase);
            Assert.AreEqual(0.00, demo.HorasExtras.calcular(), 0.10);
            Assert.AreEqual(0.00, demo.HorasDescontadas.calcular(), 0.10);
            Assert.AreEqual(8000.00, demo.TotalProventos, 0.10);
            Assert.AreEqual(800.00, demo.Inss.calcular(), 0.10);
            Assert.AreEqual(1980.00, demo.Irrf.calcular(), 0.10);
            Assert.AreEqual(2780.00, demo.TotalDescontos, 0.10);
            Assert.AreEqual(5220.00, demo.TotalLiquido, 0.10);
            Assert.AreEqual(880.00, demo.Fgts.calcular(), 0.10);
        }

        [TestMethod()]
        public void DemonstrativoTestComercioSal12000Hextras80hDesc15()
        {
            GeradorDeDemonstrativo gerar = new GeradorDeDemonstrativo();
            Demonstrativo demo = gerar.GerarDemonstrativo(170, 12000, 80, 15);
            Assert.AreEqual(12000, demo.SalarioBase);
            Assert.AreEqual(5647.05, demo.HorasExtras.calcular(), 0.10);
            Assert.AreEqual(1058.82, demo.HorasDescontadas.calcular(), 0.10);
            Assert.AreEqual(16588.23, demo.TotalProventos, 0.10);
            Assert.AreEqual(1658.82, demo.Inss.calcular(), 0.10);
            Assert.AreEqual(4105.58, demo.Irrf.calcular(), 0.10);
            Assert.AreEqual(5764.406, demo.TotalDescontos, 0.10);
            Assert.AreEqual(10823.82, demo.TotalLiquido, 0.10);
            Assert.AreEqual(1824.70, demo.Fgts.calcular(), 0.10);
        }

    }

    [TestClass]
    public class FolhaPagamentoUnitTest
    {
        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_1000()
        {
            int horasCategoria = 200;
            double salarioBase = 1000;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new GeradorDeDemonstrativo();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1000;
            var inssAliquotaEsperado = 8;
            var inssValorEsperado = 80;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 80;
            var totalLiquidoEsperado = 920;
            var fgtsAliquotaEsperado = 11;
            var fgtsValorEsperado = 110;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(valorTotalHorasExtrasEsperado, demonstrativo.HorasExtras.QtdHoras);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.calcular(), inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.calcular(), irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.calcular(), fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_139944()
        {
            int horasCategoria = 200;
            double salarioBase = 1399.44;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new GeradorDeDemonstrativo();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1399.44;
            var inssAliquotaEsperado = 9;
            var inssValorEsperado = 125.94;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 125.94;
            var totalLiquidoEsperado = 1273.5;
            var fgtsAliquotaEsperado = 11;
            var fgtsValorEsperado = 153.93;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.calcular(), valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.calcular(), valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.calcular(), inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.calcular(), irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.calcular(), fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_161287()
        {
            int horasCategoria = 200;
            double salarioBase = 1612.87;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new GeradorDeDemonstrativo();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1612.87;
            var inssAliquotaEsperado = 10;
            var inssValorEsperado = 161.28;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 161.28;
            var totalLiquidoEsperado = 1451.59;
            var fgtsAliquotaEsperado = 11;
            var fgtsValorEsperado = 177.41;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.calcular(), valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.calcular(), valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.calcular(), inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.calcular(), irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.calcular(), fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_181234()
        {
            int horasCategoria = 200;
            double salarioBase = 1812.34;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new GeradorDeDemonstrativo();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 1812.34;
            var inssAliquotaEsperado = 10;
            var inssValorEsperado = 181.23;
            var irrfAliquotaEsperado = 0;
            var irrfValorEsperado = 0;
            var totalDescontosEsperado = 181.23;
            var totalLiquidoEsperado = 1631.11;
            var fgtsAliquotaEsperado = 11;
            var fgtsValorEsperado = 199.35;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.calcular(), valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.calcular(), valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.calcular(), inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.calcular(), irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.calcular(), fgtsValorEsperado);


        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_201337()
        {
            int horasCategoria = 200;
            double salarioBase = 2013.37;
            double horasExtras = 0;
            double horasDescontadas = 0;

            var folhaPagamento = new GeradorDeDemonstrativo();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 0;
            var valorTotalHorasExtrasEsperado = 0;
            var quantidadeHorasDescontadasEsperado = 0;
            var valorTotalHorasDescontadasEsperado = 0;
            var totalProventosEsperado = 2013.37;
            var inssAliquotaEsperado = 10;
            var inssValorEsperado = 201.33;
            var irrfAliquotaEsperado = 7.5;
            var irrfValorEsperado = 135.9;
            var totalDescontosEsperado = 337.23;
            var totalLiquidoEsperado = 1676.14;
            var fgtsAliquotaEsperado = 11;
            var fgtsValorEsperado = 221.47;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.calcular(), valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.calcular(), valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.calcular(), inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.calcular(), irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado,0.01);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.calcular(), fgtsValorEsperado);
        }

        [TestMethod]
        public void Validar_Demonstrativo_Industria_Salario_5000_HrE50_HrD10()
        {
            int horasCategoria = 200;
            double salarioBase = 5000;
            double horasExtras = 50;
            double horasDescontadas = 10;

            var folhaPagamento = new GeradorDeDemonstrativo();
            var demonstrativo = folhaPagamento.GerarDemonstrativo(horasCategoria, salarioBase, horasExtras, horasDescontadas);

            var quantidadeHorasExtrasEsperado = 50;
            var valorTotalHorasExtrasEsperado = 1250;
            var quantidadeHorasDescontadasEsperado = 10;
            var valorTotalHorasDescontadasEsperado = 250;
            var totalProventosEsperado = 6000;
            var inssAliquotaEsperado = 10;
            var inssValorEsperado = 600;
            var irrfAliquotaEsperado = 27.5;
            var irrfValorEsperado = 1485;
            var totalDescontosEsperado = 2085;
            var totalLiquidoEsperado = 3915;
            var fgtsAliquotaEsperado = 11;
            var fgtsValorEsperado = 660;

            Assert.AreEqual(demonstrativo.SalarioBase, salarioBase);
            Assert.AreEqual(demonstrativo.HorasExtras.QtdHoras, quantidadeHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasExtras.calcular(), valorTotalHorasExtrasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.QtdHoras, quantidadeHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.HorasDescontadas.calcular(), valorTotalHorasDescontadasEsperado);
            Assert.AreEqual(demonstrativo.TotalProventos, totalProventosEsperado);
            Assert.AreEqual(demonstrativo.Inss.Aliquota, inssAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Inss.calcular(), inssValorEsperado);
            Assert.AreEqual(demonstrativo.Irrf.Aliquota, irrfAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Irrf.calcular(), irrfValorEsperado);
            Assert.AreEqual(demonstrativo.TotalDescontos, totalDescontosEsperado);
            Assert.AreEqual(demonstrativo.TotalLiquido, totalLiquidoEsperado);
            Assert.AreEqual(demonstrativo.Fgts.Aliquota, fgtsAliquotaEsperado);
            Assert.AreEqual(demonstrativo.Fgts.calcular(), fgtsValorEsperado);
        }
    }
}