var modulo = angular.module('ListaExercicios',[]);





modulo.controller('Lista', function($scope,$filter){
    
    
   
    let instrutores = [{
    nome: 'Bernardo',
    sobrenome:'Rezende',
    idade:'12',
    email:'mestreDosMagos@grifinoria.com',
    jaDeuAula:true,
    aulaMinistrada:'OO'}
    ,
  {
    nome: 'Nunes',
    sobrenome:'Illuminati',
    idade:'358',
    email:'donoDaMascada@illuminati.com',
    jaDeuAula:true,
    aulaMinistrada:'Banco 1'
  },
  {
    nome: 'Pedro',
    sobrenome:'Henrique Pires',
    idade:25,
    email:'php@php.php',
    jaDeuAula:true,
    aulaMinistrada:'HTML/CSS'
  }
];
    
   let aulas = [
    'OO',
    'HTML e CSS',
    'Javascript',
    'AngularJS',
    'Banco de Dados I'
  ];
    
    $scope.aulas = aulas;
    $scope.instrutores = instrutores;
    $scope.incluir = function(){
        var instrutor = {nome:$scope.nomeInserir,
    sobrenome:$scope.sobrenomeInserir,
    idade:$scope.idadeInserir,
    email:$scope.emailInserir,
    jaDeuAula:$scope.inserirJaDeuAula || false,
    aulaMinistrada:$scope.inserirAulaDada}
      $scope.instrutor = instrutor;
        // let copiaDoInstrutor = angular.copy(instrutor);
        // $scope.novoInstrutor = {};
    if($scope.meuForm.$invalid) { console.log('Form Invalido') ;return ( 'Form Invalido.');}
    instrutores.push(instrutor);
    console.log($scope.instrutores);
        $scope.nomeInserir = undefined;
        $scope.sobrenomeInserir = undefined;
        $scope.idadeInserir = undefined;
        $scope.emailInserir = undefined;
        $scope.inserirJaDeuAula = undefined;
        $scope.inserirAulaDada = undefined;
        
}})

