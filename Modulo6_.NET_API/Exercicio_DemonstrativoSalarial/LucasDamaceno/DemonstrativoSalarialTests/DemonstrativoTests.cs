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
        public void DemonstrativoTest()
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

       
    }
}