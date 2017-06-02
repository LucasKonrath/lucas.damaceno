var modulo = angular.module('editoraApp', ['ui.bootstrap']);

modulo.controller('EditoraController', function ($scope, editoraService) {
 
    $scope.myInterval = 3000;
    $scope.carregarLivros = carregarLivros;
    $scope.obterLivros = obterLivros;
    $scope.proximaPagina = proximaPagina;
    $scope.obterLancamentos = obterLancamentos;
    $scope.mostrarModal = false;
    
    function proximaPagina(){
    
    }
    function obterLivros() {
        editoraService
        .obterLivros()
        .then(response => {
            
            $scope.livros = response.data.data; 
            console.log($scope.livros);
            
        })
    }
    
    function obterLancamentos() {
        editoraService
        .obterLancamentos()
        .then(response => {
            
            $scope.lancamentos = response.data.data; 
            console.log($scope.lancamentos);
            
        })
    }
    
    function carregarLivros(){
        
        obterLancamentos();
        obterLivros();
        
    }
    
    
});