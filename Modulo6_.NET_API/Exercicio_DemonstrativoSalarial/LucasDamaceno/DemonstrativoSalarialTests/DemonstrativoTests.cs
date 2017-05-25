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
}