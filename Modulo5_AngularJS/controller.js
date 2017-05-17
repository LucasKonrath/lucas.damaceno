var modulo = angular.module('aula01',[]);

modulo.controller('Exemplo1', function($scope){
    $scope.pikachu = {nome:'pikachu', tipo:'eletrico'};
     $scope.nomeCampo = 'Monstrinho';
   // $rootScope.nomeCampo = 'Default';
    
})

modulo.controller('Exemplo2', function($scope){
    $scope.pokemons = [{nome:'pikachu', tipo:'eletrico'},{nome:'charmillion', tipo:'fogo'},{nome:'pikachu', tipo:'agua'}];
   // $rootScope.nomeCampo = 'Default';
    
})