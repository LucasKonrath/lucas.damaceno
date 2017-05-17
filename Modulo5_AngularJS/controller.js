var modulo = angular.module('aula01',[]);

modulo.controller('Exemplo1', function($scope){
    $scope.pikachu = {nome:'pikachu', tipo:'eletrico'};
     $scope.nomeCampo = 'pokemon';
    $scope.pikachu.nome = 'Wartortle';
    $scope.pikachu.tipo = '?';
   // $rootScope.nomeCampo = 'Default';
    
})