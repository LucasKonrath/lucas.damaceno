var modulo = angular.module('Exemplo3',[]);



modulo.filter('mascada',function(){

              return function(nome){

            return nome.toLowerCase().replace('nunes', '$$$$nunes$$$$');
        }});


modulo.controller('Ex3', function($scope,$filter){
 
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

    $scope.instrutores = instrutores;
});

