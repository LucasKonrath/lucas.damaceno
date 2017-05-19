var modulo = angular.module('ListaExercicios',[]);



modulo.filter('mascada',function(){
                
              return function(nome){
              var retorno = nome.replace(/([n])([u])([n])([e])([s])/gi,'$' + nome + '$');
                  if(retorno.length > nome.length) $scope.isNunes = 'eONunes';
            return retorno;
        }});

modulo.filter('filtrarAula',function(){

              return function(aula){
                
            return padNumDigitos(aula.numero,3) + "   -   " + aula.nome;
        }});

function padNumDigitos(numero, digitos) {
    return Array(Math.max(digitos - String(numero).length + 1, 0)).join(0) + numero;
}


modulo.controller('Lista', function($scope,$filter){
    
    
    
    let instrutores = [{
    nome: 'Bernardo',
    aula: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
  },
  {
    nome: 'Nunes',
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  },
  {
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  }
];

var aulasEInstrutores = [];
  
    for (instrutor of instrutores){
        for(aulas of instrutor.aula){
           let adicionar = {numero:aulas.numero,nome:aulas.nome,instrutor:instrutor.nome};
            aulasEInstrutores.push(adicionar);
        }
    }
    
    $scope.aulasEInstrutores = aulasEInstrutores;
    $scope.instrutores = instrutores;
    
})

