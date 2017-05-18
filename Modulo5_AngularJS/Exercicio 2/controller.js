var modulo = angular.module('Exercicio2',[]);

modulo.controller('Ex2', function($scope,$filter){
    
    $scope.data='18/05/2017';
    $scope.converter = converter;
    $scope.dataConvertida;
function converter(){
var stringData=$scope.data;
var splitData = stringData.split('/');
var dataConvertida = new Date(splitData[2], splitData[1]-1, splitData[0]);
$scope.dataConvertida = dataConvertida.toLocaleDateString("en-US");
$scope.dataConvertida = $filter('date')(dataConvertida,'shortDate');
};


});

