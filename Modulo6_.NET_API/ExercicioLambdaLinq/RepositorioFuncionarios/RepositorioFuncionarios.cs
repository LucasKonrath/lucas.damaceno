using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }
        
        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {

            return Funcionarios.
                   Where(func => func.Cargo.Equals(cargo)).ToList();

            
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.
                   OrderBy(func => func.Cargo.Titulo).
                   ThenBy(func => func.Nome).ToList();
                                  
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.
                   Where(func => func.Nome.Contains(nome)).ToList();
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {

            if (turnos.Length == 0)
            {
                return Funcionarios.
                       Select(func => func).ToList();
               

            }
            else
            {
                return Funcionarios.
                        Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho)).
                        ToList();
               
            }         
        }        

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {

            return Funcionarios.
                    Where(func => CalcularIdade(func.DataNascimento) < idade + 5 && 
                    CalcularIdade(func.DataNascimento) > idade - 5).
                    ToList();
             
        }

        private int CalcularIdade(DateTime dataNascimento)
        {
            return Convert.ToInt32((DateTime.Today - dataNascimento).TotalDays / 365.2425);
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            
            if (turno == null) {
               return Funcionarios.
                      Select(func => func.Cargo.Salario).
                      Average();
            }
            else
            {
                return Funcionarios.
                       Where(func => func.TurnoTrabalho.Equals(turno)).
                       Select(funcionario => funcionario.Cargo.Salario).
                       Average();
                       

            }
      
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.
                   Where(func => func.DataNascimento.Month == DateTime.Today.Month).
                   ToList();
        }

        public class ObjetoDinamico
        {

            public string NomeFuncionario { get; set; }
            public string TituloCargo { get; set; }

        }

        public IList<dynamic> BuscaRapida()
        {
            return Funcionarios.
                   Select(func => new { NomeFuncionario = func.Nome, TituloCargo = func.Cargo.Titulo }).ToArray();
          
        }
        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {

            return Funcionarios.
                    GroupBy(func => func.TurnoTrabalho)
                    .Select(func => new
                    {
                        Turno = func.First().TurnoTrabalho,
                        Quantidade = func.Count()
                    }).ToArray();

                    
        }

        public dynamic FuncionarioMaisComplexo()
        {
            var vogais = new Regex("[AaEeIiOoUu]");

            var funcionarioComplexo =
            Funcionarios.
            Where(func => func.TurnoTrabalho != TurnoTrabalho.Tarde && func.Cargo.Titulo != "Desenvolvedor Júnior").
            OrderByDescending(func => vogais.Replace(func.Nome, "").Length)
            .First();

            var stringOriginal = $"${funcionarioComplexo.Cargo.Salario}{0.00}";
            var stringNova = stringOriginal.Replace(',', '.');
            return new
            {


                Nome = funcionarioComplexo.Nome,
                DataNascimento = funcionarioComplexo.DataNascimento.ToString("dd/MM/yyyy"),
                SalarioRS = $"R$ {funcionarioComplexo.Cargo.Salario}{0.00}",
                SalarioUS = stringNova,
                QuantidadeMesmoCargo = BuscarPorCargo(funcionarioComplexo.Cargo).Count()

            };
        }
    }
}
