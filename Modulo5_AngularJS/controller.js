var modulo = angular.module('aula01',[]);

modulo.controller('Exemplo1', function($scope){
    $scope.pikachu = {nome:'pikachu', tipo:'eletrico'};
     $scope.nomeCampo = 'Monstrinho';
   // $rootScope.nomeCampo = 'Default';
    
})

modulo.controller('Exemplo2', function($scope){
    $scope.pokemons = [{nome:'Pikachu', tipo:'eletrico'},{nome:'Charmillion', tipo:'fogo'},{nome:'Blastoise', tipo:'agua'},{nome:'Clefairy', tipo:'Psiquico'},{nome:'Psiduck', tipo:'Psiquico'},{nome:'Hitmonlee', tipo:'Lutador'},{nome:'Hitmonchan', tipo:'Lutador'},{nome:'Berg', tipo:'Reporter'},{nome:'Daniel', tipo:'Paladino'},{nome:'Galo', tipo:'Cego'},{nome:'Moltres', tipo:'Lendario'}];
   // $rootScope.nomeCampo = 'Default';
    
})